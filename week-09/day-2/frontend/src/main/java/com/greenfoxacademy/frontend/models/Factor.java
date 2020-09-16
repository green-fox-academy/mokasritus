package com.greenfoxacademy.frontend.models;

public class Factor {
  private int result;

  public Factor(int until) {
    result = 1;
    for (int i = 1; i <= until; i++) {
      result = result * i;
    }
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
