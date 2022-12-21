package com.github.kasparpartel.workouttrackerrestapi.dto;

import com.github.kasparpartel.workouttrackerrestapi.model.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WorkoutDto {
    private long id;
    private List<Set> sets;
    private String type;
    private String target;
    private String description;
}
