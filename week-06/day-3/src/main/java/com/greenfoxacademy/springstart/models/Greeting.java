package com.greenfoxacademy.springstart.models;

import java.util.concurrent.atomic.AtomicLong;

public class Greeting {
  long id;
  private String content;


  public Greeting(long id, String content) {
    this.content = content;
    this.id=id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
