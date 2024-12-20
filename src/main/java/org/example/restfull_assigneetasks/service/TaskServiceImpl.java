package org.example.restfull_assigneetasks.service;

import org.example.restfull_assigneetasks.model.entity.Task;
import org.example.restfull_assigneetasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task readTask(long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public Task updateTask(Task task) {
        if (taskRepository.existsById(task.getId())) {
            return taskRepository.save(task);
        }
        return null;
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);

    }

    @Override
    public Optional<Task> partialUpdateTask(Long id, Task task) { //partialUpdate - частичный
        //апдейт
        return taskRepository.findById(id)
                .map(taskExist -> {
                    if (task.getName() != null) {
                        taskExist.setName(task.getName());
                    }
                    if (task.getDescription() != null) {
                        taskExist.setDescription(task.getDescription());
                    }
                    return taskRepository.save(taskExist);
                });
    }

    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }
}