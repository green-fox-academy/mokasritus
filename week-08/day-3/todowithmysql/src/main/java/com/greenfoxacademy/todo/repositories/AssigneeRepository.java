package com.greenfoxacademy.todo.repositories;

import com.greenfoxacademy.todo.models.Assignee;
import com.greenfoxacademy.todo.models.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
  List<Assignee> findAll();

  Assignee findAssigneeById(Long assigneeId);

  Assignee findAssigneeByTodosContaining(Todo todo);
}
