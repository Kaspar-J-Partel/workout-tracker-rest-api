package com.github.kasparpartel.workouttrackerrestapi.repository;

import com.github.kasparpartel.workouttrackerrestapi.model.Set;

import java.util.List;

public interface SetRepository {
    List<Set> findAll();

    void save(Set set);
}
