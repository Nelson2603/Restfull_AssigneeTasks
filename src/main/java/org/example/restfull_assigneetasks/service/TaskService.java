package org.example.restfull_assigneetasks.service;

import org.example.restfull_assigneetasks.model.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);

    Task readTask(long id);

    Task updateTask(Task task);

    void deleteTask(long id);

    Optional<Task> partialUpdateTask(Long id, Task task);

    List<Task> findAllTask();
}
