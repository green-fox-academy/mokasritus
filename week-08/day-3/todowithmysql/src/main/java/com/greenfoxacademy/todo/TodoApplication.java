package com.greenfoxacademy.todo;

import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {
private TodoService todoService;

  @Autowired
  public TodoApplication(TodoService todoService) {
    this.todoService = todoService;
  }

  public static void main(String[] args) {

    SpringApplication.run(TodoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
  }
}
