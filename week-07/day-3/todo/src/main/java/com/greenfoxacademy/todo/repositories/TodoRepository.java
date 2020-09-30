package com.greenfoxacademy.todo.repositories;

import com.greenfoxacademy.todo.models.Todo;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  List<Todo> findAll();
}
