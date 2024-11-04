package org.example.restfull_assigneetasks.service;

import org.example.restfull_assigneetasks.model.entity.Assignee;

public interface AssigneeService {
    Assignee addAssignee(Assignee assignee);//добавление исполнителя
    Assignee getAssignee(Long id);//получение исполнителя

}
