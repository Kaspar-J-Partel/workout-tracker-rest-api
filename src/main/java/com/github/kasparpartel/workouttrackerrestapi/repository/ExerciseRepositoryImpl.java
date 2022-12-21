package com.github.kasparpartel.workouttrackerrestapi.repository;

import com.github.kasparpartel.workouttrackerrestapi.model.Exercise;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class ExerciseRepositoryImpl implements ExerciseRepository {
    private List<Exercise> exercises = new ArrayList<>();

    @Override
    public List<Exercise> findAll() {
        return exercises;
    }

    @Override
    public void save(Exercise exercise) {
        int id = exercises.size() + 1;
        exercise.setId(id);
        exercises.add(exercise);
    }
}
