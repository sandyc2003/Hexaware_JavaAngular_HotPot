package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.hotpot.entities.User;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void deleteUser(Long id);
    User updateUser(Long id, User updatedUser);
}
