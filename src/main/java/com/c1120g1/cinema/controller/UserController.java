package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.dto.AccountDTO;
import com.c1120g1.cinema.dto.UserDTO;
import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.entity.TransactionHistory;
import com.c1120g1.cinema.entity.User;

import com.c1120g1.cinema.dto.UserEditDTO;
import com.c1120g1.cinema.dto.UserPreviewDTO;
import com.c1120g1.cinema.entity.Ward;

import com.c1120g1.cinema.service.*;
import com.c1120g1.cinema.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;


import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {
    Map<String, String> checkOTP = new HashMap<>();

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountStatusService accountStatusService;

    @Autowired
    private WardService wardService;

    @Autowired
    private AccountRoleService accountRoleService;

    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @Autowired
    private NotificationService notificationService;

    @Autowired

    private TicketService ticketService;



//Dong
    @GetMapping("/member/account/{username}")
    public ResponseEntity<Account> getAccountByUsername(@PathVariable(name = "username") String username) {
        Account account = accountService.findByAccount(username);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
//Dong
    @GetMapping("/member/transaction/{username}")
    public ResponseEntity<List<TransactionHistory>> getTransactionByUsername(@PathVariable(name = "username") String username) {
        List<TransactionHistory> transaction = transactionHistoryService.findByTransaction(username);
        if (transaction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
//Dong
    @PutMapping(value = "/member/editUser/{username}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> editUser(@PathVariable("username") String username, @RequestBody User user) {
        try {
            userService.updateUser(user, username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//Dong
    @GetMapping("/member/searchNameMovie")
    public ResponseEntity<List<TransactionHistory>> searchByNameMovie(@RequestParam(name = "username") String username,
                                                                      @RequestParam(name = "keySearch") String keySearch
    ) {
        List<TransactionHistory> transaction = transactionHistoryService.searchByNameMovie(username,keySearch);
        if (transaction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @Autowired
    UserMapper userMapper;

    @GetMapping(value = "/employee/listUser")

    public ResponseEntity<List<UserPreviewDTO>> listUser(@RequestParam int index) {
        List<User> userList = this.userService.findAll(index);
        if (userList != null) {
            return new ResponseEntity<>( userMapper.toDto( userList ), HttpStatus.OK );
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND );
    }

    @GetMapping(value = "/employee/listUser/getAll")
    public ResponseEntity<List<UserPreviewDTO>> findListUser() {
        List<User> userList = this.userService.findAllUser();
        if (userList != null) {
            return new ResponseEntity<>(userMapper.toDto(userList), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/employee/listUser/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            Map<String, String> listError = new HashMap<>();
            if (userService.findByEmail( userDTO.getEmail() ) != null) {
                listError.put( "existEmail", "Email đã tồn tại , vui lòng nhập email khác!" );
            }
            if (userService.findByUsername( userDTO.getUsername() ) != null) {
                listError.put( "existAccount", "Tài khoản đã tồn tại , vui lòng chọn tài khoản khác !" );
            }
            if (userService.findByIdCard( userDTO.getIdCard() ) != null) {
                listError.put( "existIdCard", "CMND đã tồn tại , vui lòng chọn CMND khác!" );
            }
            if (!userDTO.getPassword().equals( userDTO.getConfirmPassword() )) {
                listError.put( "notCorrect", "Mật khẩu không trùng khớp , vui lòng nhập lại !" );
            }

            if (!listError.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body( listError );
            }
            userService.saveUserCus( userDTO );
            accountRoleService.saveAccountRoleUser( userDTO.getUsername(), 3 );
            return new ResponseEntity<>( HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    @GetMapping("/employee/listUser/{id}")
    public ResponseEntity<UserEditDTO> getUserById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            return new ResponseEntity<>( userMapper.toEditDto( user ), HttpStatus.OK );
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND );
    }

    @GetMapping(value = "/employee/listUser/email")
    public ResponseEntity<?> sendEmailApprove(@RequestParam(name = "email") String email) throws
            MessagingException {
        accountService.sendEmailApprove(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/employee/listUser/edit")
    public ResponseEntity<?> editUser(@RequestBody UserDTO userDTO) {
        try {
            Map<String, String> listError = new HashMap<>();
            User user = userService.findByEmail( userDTO.getEmail() );
            if (user != null && user.getUserId() != userDTO.getUserId()) {
                listError.put( "existEmail", "Email đã tồn tại , vui lòng nhập email khác!" );
            }
            if (!userDTO.getPassword().equals( userDTO.getConfirmPassword() )) {
                listError.put( "notCorrect", "Mật khẩu không trùng khớp , vui lòng nhập lại !" );
            }
            if (!listError.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body( listError );
            }

            userService.updateUser(userDTO);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//Dong
    @PostMapping("/member/setPass")
    public ResponseEntity<AccountDTO> setNewPassword( @RequestBody AccountDTO accountDTO) {
        Account account = accountService.findByUsername(accountDTO.getUsername());
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (checkOTP.containsKey(accountDTO.getUsername())) {
            if (checkOTP.get(accountDTO.getUsername()).equals(accountDTO.getOtp())) {
                if (BCrypt.checkpw(accountDTO.getOldPassword(), account.getPassword())) {
                    accountService.setNewPassword(accountDTO);
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
//Dong
    @GetMapping("/member/sendEmailOTP")
    public ResponseEntity<String> checkEmailOTP(@RequestParam(name = "email") String email) {
        System.out.println("Email : " + email);
        User user = this.userService.findByEmail(email);
        if (user != null) {
            String code = accountService.generateCode();
            checkOTP.put(user.getAccount().getUsername(), code);
            System.out.println("CODE : " + code);
            accountService.sendEmailOTP(email, code);
            return new ResponseEntity<>(code, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/employee/listUser/search")
    public ResponseEntity<List<UserPreviewDTO>> searchAll(@RequestParam(name = "q") String q) {
        try {
            List<User> userList = this.userService.searchAllUserAttribute( q );
            if (userList != null) {
                return new ResponseEntity<>( userMapper.toSearchDto( userList ), HttpStatus.OK );
            }
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employee/listUser/searchPagination")
    public ResponseEntity<List<UserPreviewDTO>> searchAllPagination(@RequestParam(name = "q") String q,
                                                                    @RequestParam(name = "index") int index) {
        try {
            List<User> userList = this.userService.searchAllAttributePagination(q,index);
            if (userList != null) {
                return new ResponseEntity<>(userMapper.toSearchDto(userList), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }


    @PutMapping(value = "/employee/listUser/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<List<Ward>> getWard() {
        try {
            List<Ward> wards = wardService.getAllWard();
            return ResponseEntity.ok().body( wards );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put( fieldName, errorMessage );
        } );
        return errors;
    }

    /**
     * Method: Get user by cardId
     * Author: HanTH
     * @param username
     * @return
     */
    @GetMapping("api/employee/saleTicket/user/{username}")
    public ResponseEntity<User> findUserByUserName(@PathVariable String username) {
        try {
            User user = userService.findByUsername( username );
            return new ResponseEntity<>( user, HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PostMapping("api/employee/saleTicket/user/create")
    public ResponseEntity<User> creatUserNoAccount(@RequestBody User user){
        try{
            User user1 = userService.createUserNoAccount( user );
            return new ResponseEntity<>( user1, HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }


    @GetMapping("/member/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(name = "username") String username) {
        User user = userService.findByUsername1(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
