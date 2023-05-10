package com.example.demo.services;

import com.example.demo.dto.LoginDto;
import com.example.demo.models.User;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.services.Interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.UserRepository;

import java.util.Optional;
@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String loginUser(LoginDto loginDto) {
        User user = findUserByEmail(loginDto.getEmail());
        if (user == null) {
            return "Email doesn't exist!";
        }

        if (!passwordMatches(loginDto.getPassword(), user.getPassword())) {
            return "Password doesn't match!";
        }

        Optional<User> authenticatedUser = authenticateUser(loginDto.getEmail(), user.getPassword());
        if (authenticatedUser.isPresent()) {
            return "Logged in!";
        } else {
            return "Login failed!";
        }
    }
    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private boolean passwordMatches(String loginDtoPassword, String userPassword) {
        return loginDtoPassword.equals(userPassword);
    }

    private Optional<User> authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
