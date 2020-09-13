package com.greenfoxacademy.todo.repositories;

import com.greenfoxacademy.todo.models.Todo;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface TodoRepository  extends CrudRepository<Todo, Long> {

  List<Todo> findAll();

  @Query("SELECT todo From Todo todo WHERE todo.title like %:text%")
  List<Todo> findTodosByTitleContaining(String text);

 /* private List<Todo> todos;

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
  }*/
}
