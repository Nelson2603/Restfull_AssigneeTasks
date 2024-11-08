package org.example.restfull_assigneetasks.controller;

import org.example.restfull_assigneetasks.exception.ResourceNotFoundException;
import org.example.restfull_assigneetasks.model.entity.Assignee;
import org.example.restfull_assigneetasks.service.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignees")
public class AssigneeController {
    @Autowired
    private AssigneeService assigneeService;

    @PostMapping("/new")//добавление нового Исполнителя
    public ResponseEntity<Assignee> addAssignee(@RequestBody Assignee assignee) {
        assigneeService.addAssignee(assignee);
        return ResponseEntity.status(HttpStatus.CREATED).body(assignee);
    }

    @GetMapping("/{id}")// получение исполнителя
    public ResponseEntity<Assignee> getAssignee(@PathVariable long id) {
        Assignee assigneeId = assigneeService.getAssignee(id);
        if (assigneeId == null) {
            throw new ResourceNotFoundException("Assignee with id " + id + " not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(assigneeId);
    }

    //получение всех пользователей
    @GetMapping
    public ResponseEntity<List<Assignee>> getAllAssignees() {
        List<Assignee> assigneeList = assigneeService.getAllAssignees();
        return ResponseEntity.status(HttpStatus.OK).body(assigneeList);
    }

    @PutMapping("/{id}")//изменение данных
    public ResponseEntity<Assignee> updateAssignee(@PathVariable long id, @RequestBody Assignee assignee) {
       return assigneeService.updateAssignee(id, assignee)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Assignee> deleteAssignee(@PathVariable long id) {
        if (assigneeService.deleteAssignee(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(assigneeService.getAssignee(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}