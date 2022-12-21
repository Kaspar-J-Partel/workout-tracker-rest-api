package com.github.kasparpartel.workouttrackerrestapi.controller;

import com.github.kasparpartel.workouttrackerrestapi.dto.WorkoutDto;
import com.github.kasparpartel.workouttrackerrestapi.model.Workout;
import com.github.kasparpartel.workouttrackerrestapi.service.WorkoutService;
import lombok.Data;
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
public class WorkoutController {
    private final WorkoutService workoutService;

    @GetMapping("workouts")
    public List<WorkoutDto> getAll() {
        return workoutService.getAllWorkouts()
                .stream()
                .map(Workout::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("workouts")
    public WorkoutDto add(@RequestBody Workout newWorkout) {
        return workoutService.addWorkout(newWorkout).toDto();
    }
}
