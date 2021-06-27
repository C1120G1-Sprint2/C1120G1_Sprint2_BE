package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.dto.UserDTO;
import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.entity.Ward;
import com.c1120g1.cinema.service.*;
import com.c1120g1.cinema.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountStatusService accountStatusService;

    @Autowired
    private WardService wardService;

    @Autowired
    private AccountRoleService accountRoleService;

    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserMapper userMapper;


    @GetMapping(value = "/employee/listUser")
    public ResponseEntity<?> listUser(@RequestParam int index) {
        List<User> userList = this.userService.findAll(index);
        if (userList != null) {
            return new ResponseEntity<>(userMapper.toDto(userList), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/employee/listUser/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            Map<String, String> listError = new HashMap<>();
            if (userService.findByEmail(userDTO.getEmail()) != null) {
                listError.put("existEmail", "Email đã tồn tại , vui lòng nhập email khác!");
            }
            if (userService.findByUsername(userDTO.getUsername()) != null) {
                listError.put("existAccount", "Tài khoản đã tồn tại , vui lòng chọn tài khoản khác !");
            }
            if (userService.findByIdCard(userDTO.getIdCard()) != null) {
                listError.put("existIdCard", "CMND đã tồn tại , vui lòng chọn CMND khác!");
            }
            if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
                listError.put("notCorrect", "Mật khẩu không trùng khớp , vui lòng nhập lại !");
            }
            if (!listError.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body(listError);
            }
            userService.saveUserCus(userDTO);
            accountRoleService.saveAccountRoleUser(userDTO.getUsername(), 1);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee/listUser/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            return new ResponseEntity<>(userMapper.toEditDto(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/employee/listUser/edit")
    public ResponseEntity<?> editUser(@RequestBody UserDTO userDTO) {
        try {
            Map<String, String> listError = new HashMap<>();
            User user = userService.findByEmail(userDTO.getEmail());
            if (user != null && user.getUserId() != userDTO.getUserId()) {
                listError.put("existEmail", "Email đã tồn tại , vui lòng nhập email khác!");
            }
            if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
                listError.put("notCorrect", "Mật khẩu không trùng khớp , vui lòng nhập lại !");
            }
            if (!listError.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body(listError);
            }
            userService.updateUser(userDTO);
//            accountRoleService.saveAccountRoleUser(userDTO.getUsername(), 1);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employee/listUser/search")
    public ResponseEntity<?> searchAll(@RequestParam(name = "q") String q) {
        try {
            List<User> userList = this.userService.searchAllUserAttribute(q);
            if (userList != null) {
                return new ResponseEntity<>(userMapper.toSearchDto(userList), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/employee/listUser/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Ward>> getWard() {
        try {
            List<Ward> wards = wardService.getAllWard();
            return ResponseEntity.ok().body(wards);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
