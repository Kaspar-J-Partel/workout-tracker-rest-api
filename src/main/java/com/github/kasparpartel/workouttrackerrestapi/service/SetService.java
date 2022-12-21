package com.github.kasparpartel.workouttrackerrestapi.service;

import com.github.kasparpartel.workouttrackerrestapi.model.Set;
import com.github.kasparpartel.workouttrackerrestapi.repository.SetRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class SetService {
    private final SetRepository setRepository;

    public List<Set> getAllSets() {
        return setRepository.findAll();
    }

    public Set addSet(Set set) {
        setRepository.save(set);
        return set;
    }
}
