package com.greenfoxacademy.onlinetodoapp.models;

public class Todo {
  private String name;
  private boolean isComplete;
  private int id;

  private static int idCounter=0;

  public Todo() {
    isComplete = false;
    id=idCounter++;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  public void setIsComplete(boolean complete) {
    isComplete = complete;
  }

  public boolean isComplete() {
    return isComplete;
  }

  public int getId() {
    return id;
  }
}
