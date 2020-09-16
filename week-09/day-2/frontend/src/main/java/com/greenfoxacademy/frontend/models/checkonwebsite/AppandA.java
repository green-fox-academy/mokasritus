package com.greenfoxacademy.frontend.models.checkonwebsite;

public class AppandA {
  private String appended;

  public AppandA(String appandable) {
    this.appended=appandable.concat("a");
  }

  public String getAppended() {
    return appended;
  }

  public void setAppended(String appended) {
    this.appended = appended;
  }
}
