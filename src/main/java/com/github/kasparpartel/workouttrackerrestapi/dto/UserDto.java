package com.github.kasparpartel.workouttrackerrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private float weight;
    private float height;
}
