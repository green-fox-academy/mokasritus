package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping(value={"/todo"})
  public String listAllTodo(Model model){
    model.addAttribute("todos", todoService.getAllTodo());
    return "index";
  }

  @GetMapping(value={"/","list"})
  public String listBasedOnBolean(Model model, @RequestParam(required = false) boolean isActive){
    model.addAttribute("todos", todoService.getAllActive(isActive));
    return "list";
  }

  @GetMapping(value ="/add")
  public String renderAddPage(Model model) {
    model.addAttribute("newtodo", new Todo());
    return "add";
  }

  @PostMapping(value="/search")
  public String searchTodo(String text, Model model){
        model.addAttribute("foundTodo", todoService.searchTodo(text));
  }

  @PostMapping(value="/add")
  public String addNewTodo (Todo newTodo){
    todoService.addTodo(newTodo);
    return "redirect:/todo";
  }

  @PostMapping(value="/complete")
  public String completeTodo(@RequestParam long productId){
    todoService.completeTodo(productId);
    return "redirect:/list";
  }

  @PostMapping(value="/remove")
  public String removeTodo(@RequestParam long productId){
    todoService.removeTodoById(productId);
    return "redirect:/list";
  }
}
