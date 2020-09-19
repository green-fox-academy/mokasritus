package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.AssigneeService;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private TodoService todoService;
  private AssigneeService assigneeService;

  @Autowired
  public TodoController(TodoService todoService, AssigneeService assigneeService) {
    this.todoService = todoService;
    this.assigneeService=assigneeService;
  }

  @GetMapping(value = {"/todo"})
  public String listAllTodo(Model model) {
    model.addAttribute("todos", todoService.getAllTodo());
    return "index";
  }

  @GetMapping(value = {"/", "list"})
  public String showFileteredList(Model model, @RequestParam(required = false) boolean isActive) {
    model.addAttribute("todos", todoService.getAllActive(isActive));
    return "list";
  }

  @GetMapping(value = "/add")
  public String renderAddPage(Model model) {
    model.addAttribute("assignees", assigneeService.getAllAssignee());
    model.addAttribute("newtodo", new Todo());
    return "add";
  }

  @GetMapping(value = "/search")//GET, mert csak lekérdezünk
  public String searchTodo(@RequestParam String searchText, Model model) {
    model.addAttribute("todos", todoService.searchTodo(searchText));
    return "list";
  }

  @GetMapping(value = "/{id}/edit")
  public String renderEditPage(@PathVariable("id") long id, Model model) {
    model.addAttribute("todo", todoService.getTodoById(id));
    model.addAttribute("assignees", assigneeService.getAllAssignee());
    return "edit";
  }

  @GetMapping(value="addAssigneeForTodo/{id}")
  public String renderAddAssigneeForTodoPage(@PathVariable("id") long id, Model model){
    model.addAttribute("todo", todoService.getTodoById(id));
    model.addAttribute("assignees", assigneeService.getAllAssignee());
        return "addAssigneeForTodo";
  }

  @PostMapping(value="addAssigneeForTodo/{id}")
  public String addAssigneeForTodoPage(@PathVariable("id") long id, Long assignees){
    todoService.addAssigneeToTodo(id, assigneeService.getAssigneById(assignees));
    return "redirect:/todo";
  }

  @PostMapping(value = "/{id}/edit")
  public String editChoosenTodo(@PathVariable("id") long id, String title, boolean isUrgent,
                                boolean isComplete, Long assignee) {
    todoService.editTodo(id, title, isUrgent, isComplete, assigneeService.getAssigneById(assignee));
    assigneeService.addTodoToAssigne(assignee, todoService.getTodoById(id));
    return "redirect:/todo";
  }

  @PostMapping(value = "/add")
  public String addNewTodo(@ModelAttribute Todo newTodo) {
    todoService.addTodo(newTodo);
    return "redirect:/todo";
  }


  @PostMapping(value = "/complete")
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
