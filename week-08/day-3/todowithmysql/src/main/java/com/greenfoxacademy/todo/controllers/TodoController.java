package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping(value = {"/todo"})
  public String listAllTodo(Model model) {
    model.addAttribute("todos", todoService.getAllTodo());
    return "index";
  }

  @GetMapping(value = {"/", "list"})
  public String listBasedOnBolean(Model model, @RequestParam(required = false) boolean isActive) {
    //showFilteredList
    model.addAttribute("todos", todoService.getAllActive(isActive));
    return "list";
  }

  @GetMapping(value = "/add")
  public String renderAddPage(Model model) {
    model.addAttribute("newtodo", new Todo());
    return "add";
  }

  @GetMapping(value = "/search")//GET, mert csak lekérdezünk
  public String searchTodo(@RequestParam String text, Model model) {
    model.addAttribute("todos", todoService.searchTodo(text));
    return "redirect:/list";
  }

  @PostMapping(value = "/add")
  public String addNewTodo(@ModelAttribute Todo newTodo) {
    todoService.addTodo(newTodo);
    return "redirect:/todo";
  }


  @PostMapping(value = "/complete")//todoID!!!
  public String completeTodo(@RequestParam long todoId) {
    todoService.completeTodo(todoId);
    return "redirect:/list";
  }

  @PostMapping(value = "/remove")
  public String removeTodo(@RequestParam long todoId) {
    todoService.removeTodoById(todoId);
    return "redirect:/list";
  }
}
