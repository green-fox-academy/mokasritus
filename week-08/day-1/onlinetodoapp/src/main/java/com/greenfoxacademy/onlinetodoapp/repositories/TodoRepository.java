package com.greenfoxacademy.onlinetodoapp.repositories;

import com.greenfoxacademy.onlinetodoapp.models.Todo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
  private List<Todo> todos;

  public TodoRepository() {
    this.todos = new ArrayList<>();
  }

  public List<Todo> getTodos() {
    return todos;
  }
}
