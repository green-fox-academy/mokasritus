package com.greenfoxacademy.onlinetodoapp.services;

import com.greenfoxacademy.onlinetodoapp.models.Todo;
import com.greenfoxacademy.onlinetodoapp.repositories.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private TodoRepository repository;

  @Autowired
  public TodoService(TodoRepository repository) {
    this.repository = repository;
  }

  public List<Todo> getAllTodo(){
    return repository.getTodos();
  }

  public void addTodo(Todo newTodo) {
    int maxId = getAllTodo().stream().mapToInt(todo->todo.getId()).max().orElse(0);
    //maxId+1
    newTodo.setId(maxId+1);
    repository.addTodo(newTodo);
  }

  public void removeTodoById(int productId) {
    repository.removeTodoById(productId);
  }

  public void completeTodo(int productId) {
    repository.completeTodo(productId);
  }
}
