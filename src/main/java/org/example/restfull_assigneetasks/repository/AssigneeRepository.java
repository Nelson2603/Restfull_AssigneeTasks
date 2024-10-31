package org.example.restfull_assigneetasks.repository;

import org.example.restfull_assigneetasks.model.entity.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigneeRepository extends JpaRepository<Assignee, Long> {
}
