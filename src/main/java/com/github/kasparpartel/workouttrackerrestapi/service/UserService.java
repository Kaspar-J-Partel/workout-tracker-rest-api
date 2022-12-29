package com.github.kasparpartel.workouttrackerrestapi.service;

import com.github.kasparpartel.workouttrackerrestapi.model.User;
import com.github.kasparpartel.workouttrackerrestapi.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;

    public List<User> getALlUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User registerNewUser(User user) {
        userRepository.save(user);
        return user;
    }

}

// TODO Compare password and confirmPassword
// TODO Password encoding