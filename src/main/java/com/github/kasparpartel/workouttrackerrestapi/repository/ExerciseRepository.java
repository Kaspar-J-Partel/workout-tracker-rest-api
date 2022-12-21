package com.github.kasparpartel.workouttrackerrestapi.repository;

import com.github.kasparpartel.workouttrackerrestapi.model.Exercise;

import java.util.List;

public interface ExerciseRepository {
    List<Exercise> findAll();

    void save(Exercise exercise);
}
