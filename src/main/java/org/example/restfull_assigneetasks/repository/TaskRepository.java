package org.example.restfull_assigneetasks.repository;

import org.example.restfull_assigneetasks.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
