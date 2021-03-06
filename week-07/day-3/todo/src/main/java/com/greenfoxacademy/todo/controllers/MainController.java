package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Assignee;
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

@Controller
public class MainController {
  private TodoService todoService;
  private AssigneeService assigneeService;

  @Autowired
  public MainController(TodoService todoService, AssigneeService assigneeService) {
    this.todoService = todoService;
    this.assigneeService = assigneeService;
  }

  @GetMapping(value = "/todo")
  public String renderMainPage(Model model) {
    model.addAttribute("todos", todoService.findAll());
    model.addAttribute("assignees", assigneeService.findAll());
    model.addAttribute("newTodo", new Todo());
    model.addAttribute("assignee", new Assignee());
    return "main";
  }

  @GetMapping(value = {"/", "/list"})
  public String showActiveTodos(Model model) {
    model.addAttribute("todos", todoService.findActiveTodos());
    return "main";
  }

  @GetMapping(value = "/editTodo/{id}")
  public String renderEditPage(@PathVariable long id, Model model) {
    model.addAttribute("editTodo", todoService.findTodoById(id));
    model.addAttribute("assignees", assigneeService.findAll());
    return "edittodo";
  }

  @GetMapping(value = "/assignees")
  public String renderAssignees(Model model) {
    model.addAttribute("assignees", assigneeService.findAll());
    return "assignees";
  }

  @PostMapping(value = "/editTodo/{id}")
  public String editTodo(boolean urgent, boolean complete, String title, @PathVariable long id, @ModelAttribute Assignee assignee) {
    todoService.modifyTodo(todoService.findTodoById(id), urgent, complete, title, assignee);
    return "redirect:/todo";
  }
  //a html name mezőjébe írt név viszi át a primitíveket, azon a néven kell meghívni itt és hozzájuk nem kell requestparam!!

  /*@PostMapping(value = "/editTodo/{id}")
  public String editTodo(@ModelAttribute Todo editTodo) {
    todoService.addTodo(editTodo);
    return "redirect:/todo";
  }*/

  @PostMapping(value = "/addTodo")
  public String addTodo(@ModelAttribute Todo newTodo) {
    todoService.addTodo(newTodo); //setter kell a title-re, isUrgent-re, IsCompletere!!!!
    return "redirect:/todo";
  }

  @PostMapping(value = "/deleteTodo/{id}")
  public String deleteTodo(@PathVariable long id) {
    todoService.deleteTodo(id);
    return "redirect:/todo";
  }

  @PostMapping(value = "/addAssignee")
  public String addAssignee(@ModelAttribute Assignee newAssignee) {
    assigneeService.addAssignee(newAssignee);
    return "redirect:/todo";
  }
}
