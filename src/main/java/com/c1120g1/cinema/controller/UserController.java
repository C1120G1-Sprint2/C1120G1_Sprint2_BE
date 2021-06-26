package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping("api/employee/saleTicket/user/{cardId}")
    public ResponseEntity<User> findUserByCardId(@PathVariable String cardId) {
        try {
            User user = userService.findUserByCardId( cardId );
            return new ResponseEntity<>( user, HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
