package com.github.kasparpartel.workouttrackerrestapi.service;

import com.github.kasparpartel.workouttrackerrestapi.model.Exercise;
import com.github.kasparpartel.workouttrackerrestapi.repository.ExerciseRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise addExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
        return exercise;
    }
}
