package org.example.restfull_assigneetasks.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id//здесь был Наиль
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate beforeAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_assignee")
    @JsonIgnore
    private Assignee  assignee;



}
