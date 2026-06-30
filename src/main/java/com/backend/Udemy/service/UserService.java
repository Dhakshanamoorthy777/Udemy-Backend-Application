package com.backend.Udemy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Udemy.Dao.UserDao;
import com.backend.Udemy.dto.LoginRequestDto;
import com.backend.Udemy.dto.UserResponseDto;
import com.backend.Udemy.entity.User;
import com.backend.Udemy.exception.InvalidCredentialsException;
import com.backend.Udemy.exception.UserNotFoundException;
import com.backend.Udemy.util.ResponseStructure;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper mapper;

    public ResponseStructure<UserResponseDto> registerUser(User user) {

        User savedUser = userDao.registerUser(user);

        UserResponseDto dto = mapper.map(savedUser, UserResponseDto.class);
        dto.setRole(savedUser.getRole().name());

        ResponseStructure<UserResponseDto> structure = new ResponseStructure<>();

        structure.setStatusCode(201);
        structure.setMessage("User Registered Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<UserResponseDto> loginUser(LoginRequestDto request) {

        User user = userDao.loginUser(request.getEmail());

        if (user == null) {
            throw new UserNotFoundException();
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new InvalidCredentialsException();
        }

        UserResponseDto dto = mapper.map(user, UserResponseDto.class);
        dto.setRole(user.getRole().name());

        ResponseStructure<UserResponseDto> structure = new ResponseStructure<>();

        structure.setStatusCode(200);
        structure.setMessage("Login Successful");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    public String deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}