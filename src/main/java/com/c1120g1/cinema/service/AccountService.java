package com.c1120g1.cinema.service;

import com.c1120g1.cinema.dto.AccountDTO;
import com.c1120g1.cinema.entity.Account;


import javax.mail.MessagingException;
import java.util.List;

public interface AccountService {

    List<Account> findAll();

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
     * @param email,code
     */
    void sendEmail(String email, String code);

    /**
     * ThuanNN
     * @param username
     */
    void changeAccountStatus(String username);

    Account findByAccount(String username);

    Integer setNewPassword(AccountDTO accountDTO);

    void sendEmailOTP(String email, String code);

    /**
     * ThuanNN
     * @param email
     * @throws MessagingException
     */
    void sendEmailConfirm(String email) throws MessagingException;
}
