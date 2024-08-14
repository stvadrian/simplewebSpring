package com.example.simplewebspring.service;

import com.example.simplewebspring.model.User;
import com.example.simplewebspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean userExistsByUsername(String username) {
        Optional<User> user = userRepository.getUserByUsername(username);
        return user.isPresent();
    }

    public boolean userExistsByMobile(String mobile) {
        Optional<User> user = userRepository.getUserByMobileUser(mobile);
        return user.isPresent();
    }

    public boolean userExistsByUsername(String username, String password) {
        Optional<User> user = userRepository.getUserByUsername(username);
        return user.isPresent() && passwordEncoder.matches(password, user.get().getPassword());
    }



    public boolean registerUser(String username, String password, LocalDate dob, String mobile, Integer dept, Integer access, Integer site) {
        if (userExistsByUsername(username)) {
            return false;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setUserDOB(dob);
        user.setUserMobile(mobile);
        user.setUserDept(dept);
        user.setUserAccess(access);
        user.setUserSite(site);

        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
