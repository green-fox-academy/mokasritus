package com.greenfoxacademy.frontend.models;

public class Sum {
  private int result;


  public Sum(int until) {
    result = 0;
    for (int i = 1; i <= until; i++) {
      result += i;
    }
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
