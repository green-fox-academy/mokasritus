package com.greenfoxacademy.onlinetodoapp.services;

import com.greenfoxacademy.onlinetodoapp.models.Todo;
import com.greenfoxacademy.onlinetodoapp.repositories.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private TodoRepository repository;

  @Autowired
  public TodoService(TodoRepository repository) {
    this.repository = repository;
  }

  public Iterable<Todo> getAllTodo(){
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

  public void removeTodoById(long productId) {
    repository.deleteById(productId);
  }

  public void completeTodo(long productId) {
    Todo modifiedTodo= getProductById(productId);
    modifiedTodo.setIsComplete(true);
    repository.save(modifiedTodo);
    //adatbázis használatánál amikor egy Object fieldjén változtatunk mindig kell egy mentés az adott metódba
  }

  public Todo getProductById(long productId) {
    return repository.findById(productId).orElseThrow(NoSuchElementException::new);
  }
}
