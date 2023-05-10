package com.example.demo.services.Interfaces;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
    ResponseEntity<User> Register(UserDto userDto);
}
