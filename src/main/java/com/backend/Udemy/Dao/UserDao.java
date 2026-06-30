package com.backend.Udemy.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.backend.Udemy.entity.User;
import com.backend.Udemy.repository.UserRepository;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("User Id Not Found");
        }
    }

    public User updateUser(User user) {
        Optional<User> optional = userRepository.findById(user.getId());

        if (optional.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User Id Not Found");
        }
    }

    public String deleteUser(Long id) {
        Optional<User> optional = userRepository.findById(id);

        if (optional.isPresent()) {
            userRepository.deleteById(id);
            return "User Deleted Successfully";
        } else {
            throw new IllegalArgumentException("User Id Not Found");
        }
    }

    public User loginUser(String email) {
        Optional<User> optional = userRepository.findByEmail(email);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public Page<User> getUsersWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}