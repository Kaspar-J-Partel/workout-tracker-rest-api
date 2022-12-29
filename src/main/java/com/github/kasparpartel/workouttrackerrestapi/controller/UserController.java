package com.github.kasparpartel.workouttrackerrestapi.controller;

import com.github.kasparpartel.workouttrackerrestapi.dto.UserDto;
import com.github.kasparpartel.workouttrackerrestapi.model.User;
import com.github.kasparpartel.workouttrackerrestapi.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    @GetMapping("users")
    public List<UserDto> getAll() {
        return userService.getALlUsers().stream().map(User::toDto).collect(Collectors.toList());
    }

    @PostMapping("users")
    public UserDto registerNewUser(@RequestBody User newUser) throws EmailExistsException {
        Optional<User> user = userService.getByEmail(newUser.getEmail());
        if (user.isPresent()) {
            throw new EmailExistsException("There is an an account with this email address: " + user.get().getEmail());
        }

        return userService.registerNewUser(newUser).toDto();
    }
}
