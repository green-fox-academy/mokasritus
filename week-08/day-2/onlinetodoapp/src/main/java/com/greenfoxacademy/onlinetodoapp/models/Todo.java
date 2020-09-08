package com.greenfoxacademy.onlinetodoapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
  private String title;
  private boolean isComplete;
  private boolean isUrgent;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  //private static int idCounter=0;

  public Todo() {
    isComplete = false;
    isUrgent = false;
  }

  public Todo(String title) {
    this.title = title;
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
}
