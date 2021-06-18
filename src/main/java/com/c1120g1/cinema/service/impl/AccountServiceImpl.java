package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.repository.AccountRepository;
import com.c1120g1.cinema.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private JavaMailSender emailSender;

    /**
     * ThuanNN
     *
     * @param username
     * @return
     */
    @Override
    public Account findByUsername(String username) {
        return repository.findByUsername(username);
    }

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
