package com.greenfoxacademy.frontend.models;

public class DoubledValue {
  private Integer received;
  private Integer result;

  public DoubledValue(Integer received) {
    this.received = received;
    result = 2 * received;
  }

  public Integer getReceived() {
    return received;
  }

  public void setReceived(Integer received) {
    this.received = received;
  }

  public Integer getResult() {
    return result;
  }

  public void setResult(Integer result) {
    this.result = result;
  }
}
