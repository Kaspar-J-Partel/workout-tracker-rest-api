package com.github.kasparpartel.workouttrackerrestapi.controller;

import com.github.kasparpartel.workouttrackerrestapi.dto.UserDto;
import com.github.kasparpartel.workouttrackerrestapi.model.User;
import com.github.kasparpartel.workouttrackerrestapi.service.UserService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
        return userService.getALlUsers()
                .stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("users")
    public UserDto add(@RequestBody User newUser) throws ResponseStatusException {
        Optional<User> user = userService.getByEmail(newUser.getEmail());
        if (user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
        }

        return userService.addUser(newUser)
                .toDto();
    }
}
