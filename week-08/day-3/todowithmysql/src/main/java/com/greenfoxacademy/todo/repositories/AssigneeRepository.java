package com.greenfoxacademy.todo.repositories;

import com.greenfoxacademy.todo.models.Assignee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
  List<Assignee> findAll();

  Assignee findAssigneById(Long assigneeId);
}
