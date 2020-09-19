package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Assignee;
import com.greenfoxacademy.todo.services.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssigneeController {
  private AssigneeService assigneeService;

  @Autowired
  public AssigneeController(AssigneeService assigneeService) {
    this.assigneeService = assigneeService;
  }

  @GetMapping(value = "/assignee")
  public String renderAssigneesPage(Model model) {
    model.addAttribute("assignees", assigneeService.getAllAssignee());
    return "assigneeDetails";
  }

  @GetMapping(value="/assigneeAndTodos")
  public String renderAssigneesWithTodos( Model model){
    model.addAttribute("assignees", assigneeService.getAllAssignee());
    return "listAssigneeAndTodo";
  }

  @GetMapping(value = "/addAssignee")
  public String renderAddAssigneePage(Model model) {
    model.addAttribute("newAssignee", new Assignee());
    return "addAssignee";
  }

  @PostMapping(value = "/addAssingee")
  public String addNewAssignee(@ModelAttribute Assignee newAssignee) {
    assigneeService.addNewAssignee(newAssignee);
    return "redirect:/assignee";
  }

}
