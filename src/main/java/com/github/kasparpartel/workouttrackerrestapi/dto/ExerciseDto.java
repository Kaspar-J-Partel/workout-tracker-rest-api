package com.github.kasparpartel.workouttrackerrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExerciseDto {
    private long id;
    private String name;
    private String type;
    private String target;
    private String description;
}
