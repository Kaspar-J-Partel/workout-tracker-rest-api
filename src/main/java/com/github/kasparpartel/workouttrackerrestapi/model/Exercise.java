package com.github.kasparpartel.workouttrackerrestapi.model;

import com.github.kasparpartel.workouttrackerrestapi.dto.ExerciseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "target")
    private String target;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "exercise")
    private List<Set> sets;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ExerciseDto toDto() {
        return new ExerciseDto(id, name, type, target, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
