package com.github.kasparpartel.workouttrackerrestapi.dto;

import com.github.kasparpartel.workouttrackerrestapi.model.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SetDto {
    private long id;
    private Exercise exercise;
    private int repCount;
    private int setCount;
}
