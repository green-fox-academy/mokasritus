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

  public void addTodo(Todo newTodo) {
    todos.add(newTodo);
  }

  public void removeTodoById(int productId) {
    todos.remove(findTodoById(productId));
  }

  public void completeTodo(int productId) {
    todos.get(findTodoById(productId)).setIsComplete(true);
  }

  private int findTodoById(int productId) {
    int index = 0;
    for (int i = 0; i < todos.size(); i++) {
      if (todos.get(i).getId() == productId) {
        index = i;
        break;
      }
    }
    return index;
  }
}
