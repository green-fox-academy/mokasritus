package com.gfa.iamgroot.models;

public class SomeMessage {
  private String received;
  private final String translated;

  public SomeMessage() {
    translated="I am Groot!";
  }

  public SomeMessage(String received) {
    this();
    this.received = received;
  }

  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }

  public void setReceived(String received) {
    this.received = received;
  }
}
