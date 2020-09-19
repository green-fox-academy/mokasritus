package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.models.Assignee;
import com.greenfoxacademy.todo.models.Todo;
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

  public List<Assignee> getAllAssignee() {
    return assigneeRepository.findAll();
  }

  public void addNewAssignee(Assignee newAssignee) {
    assigneeRepository.save(newAssignee);
  }

  public void addTodoToAssigne(Long assignee, Todo todo) {
    getAssigneById(assignee).addTodos(todo);
  }

  public Assignee getAssigneById(Long assigneeId) {
    return assigneeRepository.findAssigneById(assigneeId);
  }


}
