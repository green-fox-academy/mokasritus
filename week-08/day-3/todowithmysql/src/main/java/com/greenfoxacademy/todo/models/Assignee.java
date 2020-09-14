package com.greenfoxacademy.todo.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "assignes")
public class Assignee {
  private String name;
  private String email;

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long id;

  @OneToMany(mappedBy = "assignee")
  private List<Todo> todos;

  public Assignee() {
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
