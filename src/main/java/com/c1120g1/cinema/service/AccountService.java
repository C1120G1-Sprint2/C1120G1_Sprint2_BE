package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Account;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface AccountService {
    Account findByUsername(String username);

    void deleteUserAccount(String username);

    List<Account> findAllAccount();

    Account getAccountByUsername(String username);

    void saveUserAccount(Account account);

     void sendEmailDelete(String email) throws  MessagingException;

    void sendEmailApprove(String email) throws MessagingException;
}
