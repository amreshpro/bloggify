package com.amreshpro.blogging.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amreshpro.blogging.model.User;
import com.amreshpro.blogging.service.UserService;



/**
 * userController
 */
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userService.getAllUsers();
        return userList.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE)
                : new ResponseEntity<>(userList, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> saveUserEntry(User user) {
        Boolean isSaved = userService.saveUserEntry(user);
        if (isSaved) {
            return new ResponseEntity<>("User saved Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save user", HttpStatus.NOT_ACCEPTABLE);
        }
    }

}