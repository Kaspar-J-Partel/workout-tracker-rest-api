package com.github.kasparpartel.workouttrackerrestapi.controller;

import com.github.kasparpartel.workouttrackerrestapi.dto.ExerciseDto;
import com.github.kasparpartel.workouttrackerrestapi.model.Exercise;
import com.github.kasparpartel.workouttrackerrestapi.service.ExerciseService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RestController()
@RequestMapping("api/v1")
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("exercises")
    public List<ExerciseDto> getAll() {
        return exerciseService.getAllExercises()
                .stream()
                .map(Exercise::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("exercises")
    public ExerciseDto add(@RequestBody Exercise newExercise) {
        return exerciseService.addExercise(newExercise)
                .toDto();
    }
}
