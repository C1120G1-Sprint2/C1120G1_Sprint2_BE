package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Account;

import java.util.List;

public interface AccountService {
    Account findByUsername(String username);

    void deleteUserAccount(String username);

    List<Account> findAllAccount();

    Account getAccountByUsername(String username);

    void saveUserAccount(Account account);

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
}
