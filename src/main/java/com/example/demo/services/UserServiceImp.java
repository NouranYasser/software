package com.example.demo.services;

import com.example.demo.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.LoginDto;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User newUser) {
        userRepository.save(newUser);
    }

    @Override
    public void updateUser(User updateUser) {
        userRepository.save(updateUser);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}


