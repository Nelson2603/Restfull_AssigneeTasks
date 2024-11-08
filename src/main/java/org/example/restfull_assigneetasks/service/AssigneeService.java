package org.example.restfull_assigneetasks.service;

import org.example.restfull_assigneetasks.model.entity.Assignee;

import java.util.List;
import java.util.Optional;

public interface AssigneeService {
    Assignee addAssignee(Assignee assignee);//добавление исполнителя

    Assignee getAssignee(Long id);//получение исполнителя

    List<Assignee> getAllAssignees();//получение всех исполнителей

    Optional<Assignee> updateAssignee(Long id, Assignee assignee);//обновление данных

    boolean deleteAssignee(Long id);//удаление исполнителя

}
