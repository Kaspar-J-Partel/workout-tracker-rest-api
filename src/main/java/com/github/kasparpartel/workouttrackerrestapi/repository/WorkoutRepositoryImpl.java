package com.github.kasparpartel.workouttrackerrestapi.repository;

import com.github.kasparpartel.workouttrackerrestapi.model.Workout;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class WorkoutRepositoryImpl implements WorkoutRepository {
    private List<Workout> workouts = new ArrayList<>();

    @Override
    public List<Workout> findAll() {
        return workouts;
    }

    @Override
    public void save(Workout workout) {
        int id = workouts.size() + 1;
        workout.setId(id);
        workouts.add(workout);
    }
}
