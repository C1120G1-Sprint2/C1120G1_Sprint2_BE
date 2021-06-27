package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.repository.AccountRepository;
import com.c1120g1.cinema.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JavaMailSender emailSender;

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

    @Override
    public void sendEmailApprove(String email) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper messageApprove = new MimeMessageHelper(message, "utf-8");
        String mailContent = "<h1 style='color: #FF8C00 '>C11-Cinema</h1>";
             mailContent += "<p>Xin chúc mừng bạn đã đăng kí thành công</p><br>" ;
             mailContent += "<a href=http://localhost:4200/ style='color: lightblue'>Nhấp vào đây</a>" + "<span> để đến với trang của chúng tôi</span>" +
                "<p>Thanks and regards!</p>";
        messageApprove.setTo(email);
        messageApprove.setSubject("[C11-Cinema]-Thông báo");
        messageApprove.setText(mailContent,true);
        emailSender.send(message);
    }

    @Override
    public void sendEmailDelete(String email) {
        SimpleMailMessage messageDelete = new SimpleMailMessage();
        messageDelete.setTo(email);
        messageDelete.setSubject("Email thông báo khoá tài khoản");
        messageDelete.setText("Xin thông báo! Tin của bạn đã bị xoá do vi phạm!" +
                " Nếu có bất kì thắc mắc nào, bạn có thể liên hệ với Admin email. \n" +
                " Thanks and regards!");
        this.emailSender.send(messageDelete);
    }

}
