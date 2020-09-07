package com.greenfoxacademy.onlinetodoapp.controllers;

import com.greenfoxacademy.onlinetodoapp.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping(value = "/todo")
  public String renderTodoPage(Model model) {
    model.addAttribute("todos", todoService.getAllTodo());
    return "index";
  }
}
