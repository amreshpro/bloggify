package com.amreshpro.blogging.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.amreshpro.blogging.model.User;
import com.amreshpro.blogging.repository.UserRepository;

/**
 * UserService
 */
@Service
public class UserService {
    UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();

    }

    public Boolean saveUserEntry(User user) {

        user.setDate(LocalDateTime.now());
        userRepository.save(user);

        return true;
    }
}