package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/member")
public class UserController {

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

    @GetMapping("/infoUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(name = "username") String username){
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/account/{username}")
    public ResponseEntity<Account> getAccountByUsername(@PathVariable(name = "username") String username){
        Account account = accountService.findByAccount(username);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping(value = "/editUser/{username}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> editUser(@PathVariable("username") String username, @RequestBody User user) {
        try {
           userService.updateUser(user,username);
                return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/editUsers/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> editUser(@PathVariable("id") Integer id, @RequestBody User user) {
        try {
            User user1 = userService.findById(id);
            if (user1 != null) {
                user.setUserId(id);
                user.setAccount(user1.getAccount());
                userService.updateUser1(user);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/setPass/{username}/{newPassword}")
    public ResponseEntity<Void> setNewPassword(@PathVariable(name = "username") String username,
                                               @PathVariable(name = "newPassword") String newPassword) {
        Account account = accountService.findByUsername(username);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountService.setNewPassword(account, newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
