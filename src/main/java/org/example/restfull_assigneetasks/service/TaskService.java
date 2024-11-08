package org.example.restfull_assigneetasks.service;

import org.example.restfull_assigneetasks.model.entity.Task;

public interface TaskService {
    Task createTask(Task task);

    Task readTask(long id);

    Task updateTask(Task task);

    void deleteTask(long id);
}
