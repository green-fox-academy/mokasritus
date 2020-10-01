package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.models.Assignee;
import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.repositories.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> findAll() {
    return todoRepository.findAll();
  }

  public void addTodo(Todo newTodo) {
    todoRepository.save(newTodo);
  }

  public Todo findTodoById(long id) {
    return todoRepository.findById(id).orElse(null);
  }

  public void modifyTodo(Todo todoById, boolean isUrgent, boolean isComplete, String title, Assignee assignee) {
  todoById.setUrgent(isUrgent);
  todoById.setComplete(isComplete);
  todoById.setTitle(title);
  todoById.setAssignee(assignee);
  todoRepository.save(todoById);
  }

  public void deleteTodo(long id) {
    Todo todoForDelete = findTodoById(id);
    todoRepository.delete(todoForDelete);
  }

  public List<Todo> findActiveTodos() {
    return todoRepository.findAllByCompleteFalse();
  }
}
