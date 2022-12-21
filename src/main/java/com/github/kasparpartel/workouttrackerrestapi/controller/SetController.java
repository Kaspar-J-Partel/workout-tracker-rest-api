package com.github.kasparpartel.workouttrackerrestapi.controller;

import com.github.kasparpartel.workouttrackerrestapi.dto.SetDto;
import com.github.kasparpartel.workouttrackerrestapi.model.Set;
import com.github.kasparpartel.workouttrackerrestapi.service.SetService;
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
public class SetController {
    private final SetService setService;

    @GetMapping("sets")
    public List<SetDto> getAll() {
        return setService.getAllSets()
                .stream()
                .map(Set::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("sets")
    public SetDto add(@RequestBody Set newSet) {
        return setService.addSet(newSet)
                .toDto();
    }
}
