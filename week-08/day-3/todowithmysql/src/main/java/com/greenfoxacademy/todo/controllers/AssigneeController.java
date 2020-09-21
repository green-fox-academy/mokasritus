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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssigneeController {
  private AssigneeService assigneeService;
  private TodoService todoService;

  @Autowired
  public AssigneeController(AssigneeService assigneeService, TodoService todoService) {
    this.assigneeService = assigneeService;
    this.todoService=todoService;
  }

  @GetMapping(value = "/assignee")
  public String renderAssigneesPage(Model model) {
    model.addAttribute("assignees", assigneeService.getAllAssignee());
   // model.addAttribute("todos", todoService.getAllTodo());
    return "assigneeDetails";
  }

  @GetMapping(value="/assigneeAndTodos/{id}")
  public String renderAssigneeWithTodos(@PathVariable("id") long id, Model model){
    model.addAttribute("assignees", assigneeService.findAssigneeByTodo(todoService.getTodoById(id)));
    //model.addAttribute("todos", todoService.getAllTodo());
    return "choosenAssigneeAndItsTodos";
  }

  @GetMapping(value = "/addAssignee")
  public String renderAddAssigneePage(Model model) {
    model.addAttribute("newAssignee", new Assignee());
    return "addAssignee";
  }

  @GetMapping(value="/assigneesAndTodos")
  public String renderAssigneesWithTodos( Model model){
    model.addAttribute("assignees", assigneeService.getAllAssignee());
    //model.addAttribute("todos", todoService.getAllTodo());
    return "listAssigneesAndItsTodos";
  }

  @PostMapping(value = "/addAssingee")
  public String addNewAssignee(@ModelAttribute Assignee newAssignee) {
    assigneeService.addNewAssignee(newAssignee);
    return "redirect:/assignee";
  }

}
