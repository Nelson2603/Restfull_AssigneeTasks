package org.example.restfull_assigneetasks.controller;

import org.example.restfull_assigneetasks.exception.ResourceNotFoundException;
import org.example.restfull_assigneetasks.model.entity.Assignee;
import org.example.restfull_assigneetasks.service.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        }return ResponseEntity.status(HttpStatus.OK).body(assigneeId);
    }
}
