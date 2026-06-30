package com.backend.Udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.Udemy.dto.LoginRequestDto;
import com.backend.Udemy.dto.UserResponseDto;
import com.backend.Udemy.entity.User;
import com.backend.Udemy.service.UserService;
import com.backend.Udemy.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseStructure<UserResponseDto> registerUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }
    

    @PostMapping("/login")
    public ResponseStructure<UserResponseDto> loginUser( @Valid @RequestBody LoginRequestDto request) {
        return userService.loginUser(request);
    }

    @GetMapping
    public ResponseStructure<List<User>> getAllUsers() {

        ResponseStructure<List<User>> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("All Users Fetched Successfully");
        structure.setData(userService.getAllUsers());

        return structure;
    }

    @GetMapping("/{id}")
    public ResponseStructure<User> findUserById(@PathVariable Long id) {

        ResponseStructure<User> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("User Found Successfully");
        structure.setData(userService.findUserById(id));

        return structure;
    }

    @PutMapping
    public ResponseStructure<User> updateUser(@RequestBody @Valid User user) {

        ResponseStructure<User> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("User Updated Successfully");
        structure.setData(userService.updateUser(user));

        return structure;
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteUser(@PathVariable Long id) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("User Deleted Successfully");
        structure.setData(userService.deleteUser(id));

        return structure;
    }
}