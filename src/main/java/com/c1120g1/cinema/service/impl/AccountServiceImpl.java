package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.repository.AccountRepository;
import com.c1120g1.cinema.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public void deleteUserAccount(String username) {
        accountRepository.deleteUserAccount(username);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.getListAccount();
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public void saveUserAccount(Account account) {
        if (account.getUsername() == null) {
            account.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        accountRepository.saveUserAccount(account.getUsername(), account.getPassword(), LocalDate.now());
    }

    @Autowired
    private JavaMailSender emailSender;

    /**
     * ThuanNN
     * @return
     */
    @Override
    public String generateCode() {
        return "" + (new Random().nextInt(900000) + 100000);
    }

    /**
     * ThuanNN
     *
     * @param email
     * @param code
     */
    @Override
    public void sendEmail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Email xác nhận tài khoản");
        message.setText("Chào bạn!\n"
                + "TRANG WEB CINEMA C11 gửi mã code OTP để xác nhận tài khoản.\n"
                + "Mã CODE bao gồm 6 số : " + code + "\n\n"
                + "Thanks and regards!");

        this.emailSender.send(message);
    }
}
