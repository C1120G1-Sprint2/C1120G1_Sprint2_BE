package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Account;

import javax.mail.MessagingException;
import java.util.List;

public interface AccountService {

    void deleteUserAccount(String username);

    List<Account> findAllAccount();

    Account getAccountByUsername(String username);

    void saveUserAccount(Account account);

    void sendEmailDelete(String email) throws  MessagingException;

    void sendEmailApprove(String email) throws MessagingException;
    /**
     * ThuanNN
     * @param username
     * @return
     */
    Account findByUsername(String username);

    /**
     * ThuanNN
     * @return
     */
    String generateCode();

    /**
     * ThuanNN
     * @param email
     * @param code
     */
    void sendEmail(String email, String code);

    Account findByAccount(String username);

    void setNewPassword(Account account, String newPassword);
}
