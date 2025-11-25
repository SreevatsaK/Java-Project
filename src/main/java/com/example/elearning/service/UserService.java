package com.example.elearning.service;

import com.example.elearning.model.User;
import com.example.elearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Find user by email & password (for login)
    public User login(String emailID, String password) {
        return userRepository.findByEmailIDAndPassword(emailID, password);
    }

    // Get user by ID
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
