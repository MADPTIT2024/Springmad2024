package com.javaspring.springmad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.javaspring.springmad.entity.User;
import com.javaspring.springmad.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return null;
        } else {
            return userRepository.save(user);
        }
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setFull_name(user.getFull_name());
            existingUser.set_active(user.is_active());
            existingUser.setHeight(user.getHeight());
            existingUser.setWeight(user.getWeight());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
