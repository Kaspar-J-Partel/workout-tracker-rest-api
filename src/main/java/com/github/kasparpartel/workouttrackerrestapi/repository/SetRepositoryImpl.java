package com.github.kasparpartel.workouttrackerrestapi.repository;

import com.github.kasparpartel.workouttrackerrestapi.model.Set;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class SetRepositoryImpl implements SetRepository {
    private List<Set> sets = new ArrayList<>();

    @Override
    public List<Set> findAll() {
        return sets;
    }

    @Override
    public void save(Set set) {
        int id = sets.size() + 1;
        set.setId(id);
        sets.add(set);
    }
}
