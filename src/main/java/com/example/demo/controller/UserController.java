package com.example.demo.controller;
import com.example.demo.services.Interfaces.RegisterService;
import com.example.demo.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.User;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.LoginDto;
import java.util.List;

@RestController
public class UserController {
      @Autowired
      private UserService userService;

      @GetMapping("/getAllUsers")
      public List <User> getAllUsers(){return userService.getAllUsers();}

      @PostMapping ("/AddUser")
      public String addUser (@RequestBody User newUser) {
              userService.addUser(newUser);
              return "Add User Successfully!!";
      }
      @PutMapping ("/UpdateUser")
      public ResponseEntity<User> updateUser (@RequestBody User updatedUser) {
            userService.updateUser(updatedUser);
            return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
      }
      @DeleteMapping ("/DeleteUser")
      public String deleteUser (@RequestParam Integer id) {
            userService.deleteUser(id);
            return "delete User Successfully";
      }
}

