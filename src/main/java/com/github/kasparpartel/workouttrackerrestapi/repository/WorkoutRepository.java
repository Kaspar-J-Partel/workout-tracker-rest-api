package com.github.kasparpartel.workouttrackerrestapi.repository;

import com.github.kasparpartel.workouttrackerrestapi.model.Workout;

import java.util.List;

public interface WorkoutRepository {
    List<Workout> findAll();

    void save(Workout workout);
}
