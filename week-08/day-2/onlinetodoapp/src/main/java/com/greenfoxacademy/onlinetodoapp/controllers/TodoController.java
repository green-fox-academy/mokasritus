package com.greenfoxacademy.onlinetodoapp.controllers;

import com.greenfoxacademy.onlinetodoapp.models.Todo;
import com.greenfoxacademy.onlinetodoapp.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping(value={"/", "list"})
  public String list(Model model){
    model.addAttribute("todos", todoService.getAllTodo());
    return "list";
  }

  @GetMapping(value ="/todo")
  public String renderTodoPage(Model model) {
    model.addAttribute("todos", todoService.getAllTodo());
    model.addAttribute("newtodo", new Todo());
    return "index";
  }

  @PostMapping(value="/add")
  public String addNewTodo (Todo newTodo){
    todoService.addTodo(newTodo);
    return "redirect:/todo";
  }

  @PostMapping(value="/complete")
  public String completeTodo(@RequestParam long productId){
    todoService.completeTodo(productId);
    return "redirect:/todo";
  }

  @PostMapping(value="/remove")
  public String removeTodo(@RequestParam long productId){
    todoService.removeTodoById(productId);
    return "redirect:/todo";
  }

}
