package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.common.AuthLogin;
import com.c1120g1.cinema.dto.UserDTO;
import com.c1120g1.cinema.dto.UserGoogleDTO;
import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.security.JwtResponse;
import com.c1120g1.cinema.security.JwtTokenUtil;
import com.c1120g1.cinema.service.AccountRoleService;
import com.c1120g1.cinema.service.AccountService;
import com.c1120g1.cinema.service.UserService;
import com.c1120g1.cinema.service.impl.UserDetailsServiceImpl;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class SecurityController {
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRoleService accountRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${google.clientId}")
    String googleClientId;

    /**
     * Method: authentication login method
     * Author: ThuanNN
     * @param authLogin
     * @return
     */
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody AuthLogin authLogin) {
        try {
            System.out.println(authLogin.getPassword());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authLogin.getUsername(), authLogin.getPassword())
            );
            UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authentication.getName());
            String jwtToken = jwtTokenUtil.generateToken(userDetails);
            User user = this.userService.getUserByUsername(userDetails.getUsername());
            if (user == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            JwtResponse jwtResponse = new JwtResponse(jwtToken, user, userDetails.getAuthorities());
            return ResponseEntity.ok(jwtResponse);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Method: checking email, if email in system then send code to email, else return status NOT_FOUND
     * Author: ThuanNN
     * @param email
     * @return
     */

    @GetMapping("/api/checkEmail/{email}")
    public ResponseEntity<String> checkEmail(@PathVariable(name = "email") String email) {
        System.out.println("Email : " + email);
        User user = this.userService.findByEmail(email);
        if (user != null) {
            String code = accountService.generateCode();
            System.out.println("CODE : " + code);
            accountService.sendEmail(email, code);
            return new ResponseEntity<>(code, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * ThuanNN
     * @param jwtResponseSocial
     * @return
     * @throws IOException
     */
    @PostMapping("api/login/google")
    public ResponseEntity<?> loginGoogle(@RequestBody UserGoogleDTO jwtResponseSocial) throws IOException {
        final NetHttpTransport netHttpTransport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder builder =
                new GoogleIdTokenVerifier.Builder(netHttpTransport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(builder.getJsonFactory(), jwtResponseSocial.getToken());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();

        User newUser = userService.findByEmail(payload.getEmail());

        if (newUser == null) {
            newUser = new User();
            newUser.setEmail(jwtResponseSocial.getEmail());
            newUser.setName(jwtResponseSocial.getName());
            newUser.setAvatarUrl(jwtResponseSocial.getAvatarUrl());

            Account account = new Account();
            account.setUsername(jwtResponseSocial.getEmail());
            account.setPassword(passwordEncoder.encode(""));
            accountService.saveUserAccount(account);
            newUser.setAccount(account);

            userService.saveUserSocial(newUser);
            accountRoleService.saveAccountRoleUser(newUser.getAccount().getUsername(), 3);//set default role account = 3 (ROLE_MEMBER)
            User finalUser = userService.findByUsername(newUser.getAccount().getUsername());

            UserDetails userDetails = userDetailsService.loadUserByUsername(finalUser.getAccount().getUsername());
            JwtResponse jwtResponse = new JwtResponse(jwtResponseSocial.getToken(), finalUser, userDetails.getAuthorities());

            return ResponseEntity.ok(jwtResponse);
        }

        Account account = newUser.getAccount();
        AuthLogin jwtRequest = new AuthLogin(account.getUsername(), account.getPassword());
        UserDetails userDetails = userDetailsService
                .loadUserByUsername(jwtRequest.getUsername());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(jwtToken, newUser, userDetails.getAuthorities());

        return ResponseEntity.ok(jwtResponse);
    }

    /**
     * ThuanNN
     *
     * @param jwtResponseSocial
     * @return
     */
    @PostMapping("api/login/facebook")
    public ResponseEntity<?> loginFacebook(@RequestBody UserGoogleDTO jwtResponseSocial) {
        System.out.println("Token : " + jwtResponseSocial.getToken());
//        Facebook facebook = new FacebookTemplate(jwtResponseSocial.getToken());
//        final String[] fields = {"email", "name"};
//        org.springframework.social.facebook.api.User user = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, fields);
        User newUser = userService.findByEmail(jwtResponseSocial.getEmail());

        if (newUser == null) {
            newUser = new User();
            newUser.setEmail(jwtResponseSocial.getEmail());
            newUser.setName(jwtResponseSocial.getName());
            newUser.setAvatarUrl(jwtResponseSocial.getAvatarUrl());

            Account account = new Account();
            account.setUsername(jwtResponseSocial.getEmail());
            account.setPassword(passwordEncoder.encode(""));
            accountService.saveUserAccount(account);
            newUser.setAccount(account);

            userService.saveUserSocial(newUser);
            accountRoleService.saveAccountRoleUser(newUser.getAccount().getUsername(), 3);//set default role account = 3 (ROLE_MEMBER)
            User finalUser = userService.findByUsername(newUser.getAccount().getUsername());

            UserDetails userDetails = userDetailsService.loadUserByUsername(finalUser.getAccount().getUsername());
            JwtResponse jwtResponse = new JwtResponse(jwtResponseSocial.getToken(), finalUser, userDetails.getAuthorities());

            return ResponseEntity.ok(jwtResponse);
        }

        Account account = newUser.getAccount();
        AuthLogin jwtRequest = new AuthLogin(account.getUsername(), account.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(jwtToken, newUser, userDetails.getAuthorities());

        return ResponseEntity.ok(jwtResponse);
    }

    /**
     * ThuanNN
     * Confirm email
     * @param username,email
     * @return
     */
    @PutMapping(value = "/api/register/confirmEmail/{username}/{email}")
    public ResponseEntity<User> confirmEmail(@PathVariable("username") String username, @PathVariable("email") String email) {
        System.out.println("call correct link: "+username+", "+email);
        if (userService.findByEmail(email).equals(userService.getUserByUsername(username))) {
            accountService.changeAccountStatus(username);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    /**
     * ThuanNN
     * Create user WITHOUT confirm email
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/api/createConfirm")
    public ResponseEntity<?> createUserConfirm(@RequestBody UserDTO userDTO) {
        try {
            Map<String, String> listError = new HashMap<>();
            if (userService.findByEmail(userDTO.getEmail()) != null) {
                listError.put("existEmail", "Email đã tồn tại , vui lòng nhập email khác!");
            }
            if (userService.findByUsername(userDTO.getUsername()) != null) {
                listError.put("existAccount", "Tài khoản đã tồn tại , vui lòng chọn tài khoản khác !");
            }
            if (userService.findByIdCard(userDTO.getIdCard()) != null) {
                listError.put("existIdCard", "CMND đã tồn tại , vui lòng chọn CMND khác!");
            }
            if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
                listError.put("notCorrect", "Mật khẩu không trùng khớp , vui lòng nhập lại !");
            }

            if (!listError.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body(listError);
            }
            userService.saveUserCusConfirm(userDTO);
            accountRoleService.saveAccountRoleUser(userDTO.getUsername(), 3); // set new user have role ROLE_MEMBER
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * ThuanNN
     * Send email
     * @param email
     * @return
     * @throws MessagingException
     */
    @GetMapping(value = "/api/emailConfirm")
    public ResponseEntity<?> sendEmailConfirm(@RequestParam(name = "email") String email) throws MessagingException {
        accountService.sendEmailConfirm(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
