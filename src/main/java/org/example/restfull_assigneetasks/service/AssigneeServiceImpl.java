package org.example.restfull_assigneetasks.service;

import org.example.restfull_assigneetasks.model.entity.Assignee;
import org.example.restfull_assigneetasks.repository.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssigneeServiceImpl implements AssigneeService {
    @Autowired
    private AssigneeRepository assigneeRepository;
    @Override
    public Assignee addAssignee(Assignee assignee) {
        return assigneeRepository.save(assignee);
    }

    @Override
    public Assignee getAssignee(Long id) {
        return assigneeRepository.findById(id).orElse(null);
    }
}
