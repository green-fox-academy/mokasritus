package com.greenfoxacademy.todo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="todos")
public class Todo {

  private String title;

  private boolean isComplete;

  private boolean isUrgent;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  //private static int idCounter=0;

  @ManyToOne
  private Assignee assignee;


  public Todo() {
    isComplete = false;
    isUrgent = false;
  }

  public Todo(String title, Assignee assignee) {
    this(); //üres constructort hívja meg
    this.title = title;
    this.assignee=assignee;
    //isComplete = false;
    //isUrgent = false;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public boolean isComplete() {
    return isComplete;
  }

  public long getId() {
    return id;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setIsComplete(boolean complete) {
    isComplete = complete;
  }

  public boolean isUrgent() {
    return isUrgent;
  }

  public void setUrgent(boolean urgent) {
    isUrgent = urgent;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }
}
