package org.example.restfull_assigneetasks.service;

import org.example.restfull_assigneetasks.model.entity.Assignee;
import org.example.restfull_assigneetasks.repository.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    @Override
    public List<Assignee> getAllAssignees() {
        return assigneeRepository.findAll();
    }

    @Override
    // Обновление исполнителя
    public Optional<Assignee> updateAssignee(Long id, Assignee updatedAssignee) {
        return assigneeRepository.findById(id)
                .map(existingAssignee -> {
                    existingAssignee.setUsername(updatedAssignee.getUsername());
                    existingAssignee.setPassword(updatedAssignee.getPassword());
                    return assigneeRepository.save(existingAssignee);
                });
    }


    @Override //удаление исполнителя
    public boolean deleteAssignee(Long id) {
        if (assigneeRepository.existsById(id)) {
            assigneeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
