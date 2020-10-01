package com.greenfoxacademy.todo.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Assignee {
  private String name;
  private String email;

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long id;

  @OneToMany (mappedBy = "assignee",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<Todo> todos ;

  public Assignee() {
    todos = new ArrayList<>();
  }

  public Assignee(String name, String email) {
    this();
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public long getId() {
    return id;
  }

  public List<Todo> getTodos() {
    return todos;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
