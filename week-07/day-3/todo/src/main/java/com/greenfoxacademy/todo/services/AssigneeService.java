package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.models.Assignee;
import com.greenfoxacademy.todo.repositories.AssigneeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssigneeService {
  private AssigneeRepository assigneeRepository;

  @Autowired
  public AssigneeService(AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }

  public void addAssignee(Assignee newAssignee) {
    assigneeRepository.save(newAssignee);
  }

  public List<Assignee> findAll() {
    return assigneeRepository.findAll();
  }

  public Assignee findByName(String assignee) {
    return assigneeRepository.findAssigneeByName(assignee);
  }
}
