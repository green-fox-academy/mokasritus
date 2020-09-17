package com.greenfoxacademy.frontend.models.checkonwebsite;

public class AppendA {
  private String appended;

  public AppendA(String appandable) {
    this.appended=appandable.concat("a");
  }

  public String getAppended() {
    return appended;
  }

  public void setAppended(String appended) {
    this.appended = appended;
  }
}
