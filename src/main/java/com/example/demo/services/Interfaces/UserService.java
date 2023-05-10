package com.example.demo.services.Interfaces;
import com.example.demo.models.User;
import com.example.demo.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface UserService {



    List<User> getAllUsers();
    void addUser(User newUser);
    void updateUser(User updateUser);
    void deleteUser(Integer id);
}
