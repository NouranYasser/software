package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.Interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/Login")
    public String Login(@RequestBody LoginDto loginDTO) {
        return  loginService.loginUser(loginDTO);
    }
}
