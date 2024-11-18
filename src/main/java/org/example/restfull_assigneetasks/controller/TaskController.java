package org.example.restfull_assigneetasks.controller;

import org.example.restfull_assigneetasks.model.entity.Assignee;
import org.example.restfull_assigneetasks.model.entity.Task;
import org.example.restfull_assigneetasks.service.AssigneeService;
import org.example.restfull_assigneetasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    private AssigneeService assigneeService;


    @GetMapping
    public List<Task> findAllTasks(@RequestParam(name = "date", required = false) String date) {
        //в зависимости от date вернуть задачи пройденные или не пройденные или все задачи если date = null
        return  taskService.findAllTask();

    }


    @GetMapping("/{id}") //для получения задачи по ID.
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        Task task = taskService.readTask(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }//мой коммент
    }

    @PostMapping("/new") // для создания новой задачи.
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{id}")//полная замена
    ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task task) {  //для обновления существующей задачи.
        task.setId(id);
        Task updatedTask = taskService.updateTask(task);
        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")   //для удаления задачи по ID.
    public ResponseEntity<Task> deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build(); // noContent() - возвращает HTTP-ответ со статусом 204 No Content.
        // Этот статус означает,что запрос был успешно обработан, но в ответе не содержится данных.
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> partialUpdateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.partialUpdateTask(id, task)
                .map(updatedTask -> ResponseEntity.ok().body(updatedTask))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
