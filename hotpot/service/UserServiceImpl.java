package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.entities.User;
import com.hexaware.hotpot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        String currentUsername = getCurrentUsername();

        // Allow access if user is admin or requesting their own data
        if (!hasRole("ROLE_ADMIN") && !user.getUserName().equals(currentUsername)) {
            throw new AccessDeniedException("You are not authorized to access this user.");
        }

        return Optional.of(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            String currentUsername = getCurrentUsername();

            if (!hasRole("ROLE_ADMIN") && !existingUser.getUserName().equals(currentUsername)) {
                throw new AccessDeniedException("You are not authorized to update this user.");
            }

            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setContactNumber(updatedUser.getContactNumber());
            existingUser.setGender(updatedUser.getGender());
            return userRepository.save(existingUser);
        }

        return null;
    }

    // Get logged-in user's username
    private String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    // Check if user has a specific role
    private boolean hasRole(String roleName) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals(roleName));
    }
}
