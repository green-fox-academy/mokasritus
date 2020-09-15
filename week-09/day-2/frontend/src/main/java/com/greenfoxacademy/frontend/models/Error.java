package com.greenfoxacademy.frontend.models;

public class InputError {
  private String error;

  public InputError() {
    error="Please provide an input!";
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
