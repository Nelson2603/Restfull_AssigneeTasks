package org.example.restfull_assigneetasks.controller;

import org.example.restfull_assigneetasks.model.entity.Task;
import org.example.restfull_assigneetasks.service.AssigneeService;
import org.example.restfull_assigneetasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    private AssigneeService assigneeService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        Task task = taskService.readTask(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{assigneeId}")
    public ResponseEntity<Task> createTask(@PathVariable Long assigneeId, @RequestBody Task task) {
        return assigneeService.getAssignee(assigneeId)
                .map(assignee -> {
                    task.setAssignee(assignee);
                    Task createdTask = taskService.createTask(task);
                    return ResponseEntity.ok(createdTask);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
