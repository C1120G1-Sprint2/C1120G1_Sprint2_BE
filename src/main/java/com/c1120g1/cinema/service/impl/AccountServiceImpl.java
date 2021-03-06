package com.c1120g1.cinema.service.impl;
import com.c1120g1.cinema.dto.AccountDTO;
import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.repository.AccountRepository;
import com.c1120g1.cinema.service.AccountService;
import com.c1120g1.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import java.util.List;


import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private UserService userService;

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
        String statusAccount = "2";
        if (account.getUsername() == null) {
            account.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        accountRepository.saveUserAccount(account.getUsername(), account.getPassword(), LocalDate.now(), statusAccount);
    }

    @Override
    public void sendEmailApprove(String email) throws MessagingException {
        User user = userService.findByEmail(email);
        System.out.println(user.getAccount().getUsername());
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper messageApprove = new MimeMessageHelper(message, "utf-8");
        String mailContent = "<h1 style='color: #FF8C00 '>C11-Cinema</h1>";
        mailContent += "<p>Xin ch??c m???ng b???n ???? ????ng k?? th??nh c??ng</p><br>";
        mailContent += "<p>T??i kho???n: " + user.getAccount().getUsername() + "</p>";
        mailContent += "<p>M???t kh???u : " + "admin123" + "</p>";
        mailContent += "<p>??i???m     : " + user.getAccount().getPoint() + "</p>";
        mailContent += "<p>Ng??y t???o : " + user.getAccount().getRegisterDate() + "</p>";
        mailContent += "<a href=http://localhost:4200/login style='color: lightblue'>Nh???p v??o ????y ????? ????ng nh???p</a>" + "<span> ????? ?????n v???i trang c???a ch??ng t??i</span>" +
                "<p>Thanks and regards!</p>";
        messageApprove.setTo(email);
        messageApprove.setSubject("[C11-Cinema]-Th??ng b??o");
        messageApprove.setText(mailContent, true);
        emailSender.send(message);
    }

    @Override
    public void sendEmailDelete(String email) {
        SimpleMailMessage messageDelete = new SimpleMailMessage();
        messageDelete.setTo(email);
        messageDelete.setSubject("Email th??ng b??o kho?? t??i kho???n");
        messageDelete.setText("Xin th??ng b??o! Tin c???a b???n ???? b??? xo?? do vi ph???m!" +
                " N???u c?? b???t k?? th???c m???c n??o, b???n c?? th??? li??n h??? v???i Admin email. \n" +
                " Thanks and regards!");
        this.emailSender.send(messageDelete);
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
     * @param email
     * @param code
     */
    @Override
    public void sendEmail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Email x??c nh???n t??i kho???n");
        message.setText("Ch??o b???n!\n"
                + "TRANG WEB CINEMA C11 g???i m?? code OTP ????? x??c nh???n t??i kho???n.\n"
                + "M?? CODE bao g???m 6 s??? : " + code + "\n\n"
                + "Thanks and regards!");
        this.emailSender.send(message);
    }


    @Override
    public Account findByAccount(String username) {
        return accountRepository.findByUsername(username);
    }


    @Override
    public Integer setNewPassword(AccountDTO accountDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        accountDTO.setNewPassword(passwordEncoder.encode(accountDTO.getNewPassword()));
        accountRepository.saveAccountDto(accountDTO.getNewPassword(),accountDTO.getUsername());
        return null;
    }
    @Override
    public void sendEmailOTP(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Email l???y l???i m???t kh???u t??? Cinema C11");
        message.setText("Ch??o b???n!\n"
                + "TRANG Cinema C11 g???i m?? code OTP b??n d?????i ????? ?????i l???i m???t kh???u.\n"
                + "M?? CODE bao g???m 6 s??? : " + code + "\n\n"
                + "Thanks and regards!");
        this.emailSender.send(message);
    }

    /**
     * ThuanNN
     *
     * @param username
     */
    @Override
    public void changeAccountStatus(String username) {
        accountRepository.changeAccountStatus(username);
    }

    /**
     * ThuanNN
     * Send email
     * @param email
     * @throws MessagingException
     */
    @Override
    public void sendEmailConfirm(String email) throws MessagingException {
        User user = userService.findByEmail(email);
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper messageApprove = new MimeMessageHelper(message, "utf-8");
        String mailContent = "<h1 style='color: #FF8C00 '>C11-Cinema</h1>";
        mailContent += "<p>Xin ch??c m???ng b???n ???? ????ng k?? th??nh c??ng</p><br>";
        mailContent += "<p>T??i kho???n: " + user.getAccount().getUsername() + "</p>";
        mailContent += "<p>Ng??y t???o : " + user.getAccount().getRegisterDate() + "</p>";
        mailContent += "<a href=\"http://localhost:4200/register/confirmEmail/"
                + user.getAccount().getUsername() + "/" + user.getEmail() +
                "\" style='color: lightblue'>Nh???p v??o ????y ????? x??c nh???n t??i kho???n</a>" +
                "<span> ????? ?????n v???i trang c???a ch??ng t??i</span>" +
                "<p>Thanks and regards!</p>";
        messageApprove.setTo(email);
        messageApprove.setSubject("[C11-Cinema]-Th??ng b??o");
        messageApprove.setText(mailContent, true);
        emailSender.send(message);
    }
}
