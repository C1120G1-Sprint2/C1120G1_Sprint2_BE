package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.common.AuthLogin;
import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.security.JwtResponse;
import com.c1120g1.cinema.security.JwtTokenUtil;
import com.c1120g1.cinema.service.AccountService;
import com.c1120g1.cinema.service.UserService;
import com.c1120g1.cinema.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
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

    /**
     * Method: authentication login method
     * Author: ThuanNN
     *
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
     *
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
     * Method: getUser
     * Author: ThuanNN
     *
     * @return
     */
    @GetMapping("/api/loginGoogle")
    public ResponseEntity<Principal> getUser(Principal principal) {
        if (principal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(principal, HttpStatus.OK);
    }
}
