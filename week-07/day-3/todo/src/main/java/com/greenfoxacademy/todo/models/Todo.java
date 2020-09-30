package com.greenfoxacademy.todo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Todo {
  private String title;
  private boolean urgent;
  private boolean complete;
  //ne nevezd el úgy hogy isUrgent meg isComplet, mert nem tudja a thymeleaf kezelni. ugyanaz lesz a neve mint a getter

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long id;

  public Todo() {
    urgent =false;
    complete =false;
  }

  public Todo(String title) {
    this();
    this.title = title;
  }

  public Todo(String title, boolean urgent, boolean complete) {
    this.title = title;
    this.urgent = urgent;
    this.complete = complete;
  }

  public String getTitle() {
    return title;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public boolean isComplete() {
    return complete;
  }

  public long getId() {
    return id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }
}
