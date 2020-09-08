package com.greenfoxacademy.onlinetodoapp;

import com.greenfoxacademy.onlinetodoapp.models.Todo;
import com.greenfoxacademy.onlinetodoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinetodoappApplication implements CommandLineRunner {
  public TodoService todoService;

  @Autowired
  public OnlinetodoappApplication(TodoService todoService) {
    this.todoService = todoService;
  }

  public static void main(String[] args) {
    SpringApplication.run(OnlinetodoappApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoService.addTodo(new Todo("I have to learn Object Relational Mapping"));
    todoService.addTodo(new Todo("I have to use the annotations"));
  }
}
