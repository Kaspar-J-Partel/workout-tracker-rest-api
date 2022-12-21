package com.github.kasparpartel.workouttrackerrestapi.service;

import com.github.kasparpartel.workouttrackerrestapi.model.Workout;
import com.github.kasparpartel.workouttrackerrestapi.repository.WorkoutRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout addWorkout(Workout workout) {
        workoutRepository.save(workout);
        return workout;
    }
}
