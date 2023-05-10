package com.example.demo.services;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.services.Interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<User> Register(UserDto userDto) {
        User user = new User(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhone(),
                userDto.getType(),
                userDto.getStatus()
        );
        userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
