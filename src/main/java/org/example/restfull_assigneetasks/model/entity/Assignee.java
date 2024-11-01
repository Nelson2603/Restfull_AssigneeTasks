package org.example.restfull_assigneetasks.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Assignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,unique = true)
    String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "assignee",orphanRemoval = true) //orphanRemoval = true  - сущности должны автоматически удалятся из бд,
    // если они больше не связаны с родительской сущностью

    List<Task> tasks = new ArrayList<>();



}
