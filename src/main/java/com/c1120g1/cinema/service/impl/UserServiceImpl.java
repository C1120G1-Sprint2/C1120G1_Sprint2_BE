package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.dto.UserDTO;
import com.c1120g1.cinema.dto.UserEditDTO;
import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.entity.AccountStatus;
import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.repository.AccountRepository;
import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.repository.UserRepository;
import com.c1120g1.cinema.service.AccountService;
import com.c1120g1.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll(int index) {
        return userRepository.getAllUser(index);
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userRepository.updateUser(userDTO.getUserId(), standardizeName(userDTO.getName()),
                userDTO.getEmail(), userDTO.getPhone(), userDTO.getWard(),
                userDTO.getAvatarUrl(),userDTO.getGender(),userDTO.getBirthday());

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public User findByIdCard(String idCard) {
        return userRepository.getUserByIdCard(idCard);
    }

    @Override
    public void saveUserCus(UserDTO userDTO) {

        Account account = new Account();
        account.setUsername(userDTO.getUsername());
        account.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        if (userDTO.getUsername() == null) {
            account.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        accountRepository.saveUserAccount(account.getUsername(), account.getPassword(), LocalDate.now());

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setWard(userDTO.getWard());
        user.setBirthday(userDTO.getBirthday());
        user.setGender(userDTO.getGender());
        user.setIdCard(userDTO.getIdCard());
        user.setAvatarUrl(userDTO.getAvatarUrl());
        user.setAccount(account);
        userRepository.saveUserCus(user.getAvatarUrl(),
                standardizeName(user.getName()),
                user.getAccount().getUsername(),
                user.getEmail(),
                user.getBirthday(),
                user.getIdCard(),
                user.getGender(),
                user.getPhone(),
                user.getWard().getWardId());
//        try {
//            accountService.sendEmailApprove(user.getEmail());
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void deleteUserById(Integer id) {
        User user= userRepository.findUserById(id);
        if (user != null){
            Account account = user.getAccount();
            if (account != null) {
                AccountStatus accountStatus = new AccountStatus();
                accountStatus.setAccountStatusId(3);
                account.setAccountStatus(accountStatus);
                accountRepository.save(account);
            }
        }

    }

    @Override
    public List<User> searchAllUserAttribute(String key) {
        return userRepository.searchAll(key);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }


    // chuẩn hoá tên
    public String standardizeName(String name) {
        name = name.toLowerCase();
        name = name.replaceAll("\\s+", " ");
        name = name.trim();
        String name2 = "";
        String temp = "";
        String[] words = name.split("\\s");
        for (String w : words) {
            temp = w.substring(0, 1).toUpperCase();
            for (int i = 1; i < w.length(); i++) {
                temp += w.charAt(i);
            }
            name2 += temp + " ";
        }
        name = name2.trim();
        return name;
    }

    /**
     * ThuanNN
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<User> searchAllAttributePagination(String q, int index) {
        return userRepository.getListSearchPagination(q,index);
    }
}
