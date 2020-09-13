package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.repositories.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private TodoRepository repository;

  @Autowired
  public TodoService(TodoRepository repository) {
    this.repository = repository;
  }

  public Iterable<Todo> getAllTodo() {
    return repository.findAll();
  }

  public void addTodo(Todo newTodo) {
    //List<Todo> list = new ArrayList<>();
    //repository.findAll().forEach(list::add);
    //long maxId = list.stream().mapToLong(todo->todo.getId()).max().orElse(0);
    //maxId+1
    //newTodo.setId(maxId+1);
    repository.save(newTodo);
  }

  public void removeTodoById(long todoId) {
    repository.deleteById(todoId);
  }

  public void completeTodo(long todoId) {
    Todo modifiedTodo = getProductById(todoId);
    modifiedTodo.setIsComplete(true);
    repository.save(modifiedTodo);
    //adatbázis használatánál amikor egy Object fieldjén változtatunk mindig kell egy mentés az adott metódba
  }

  public Todo getProductById(long todoId) {
    return repository.findById(todoId).orElseThrow(NoSuchElementException::new);
  }

  public List<Todo> getAllActive(boolean isActive) { //repo-ból úgy kérjem ki
    List<Todo> list = new ArrayList<>(repository.findAll());
    return list.stream().filter(todo -> todo.isComplete() != isActive)
        .collect(Collectors.toList());
  }

  public List<Todo> searchTodo(String text) {
   // return repository.findTodosByTitleContaining(text);

    return repository.findAll().stream().filter(todo -> (todo.getTitle().toLowerCase()).contains((text).toLowerCase())).collect(
      Collectors.toList());
  }
}
