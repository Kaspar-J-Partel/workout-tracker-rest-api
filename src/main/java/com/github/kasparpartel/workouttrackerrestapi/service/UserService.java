package com.github.kasparpartel.workouttrackerrestapi.service;

import com.github.kasparpartel.workouttrackerrestapi.model.User;
import com.github.kasparpartel.workouttrackerrestapi.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;

    public List<User> getALlUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }
}
