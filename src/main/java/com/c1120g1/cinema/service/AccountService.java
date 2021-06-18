package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Account;

public interface AccountService {
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
}
