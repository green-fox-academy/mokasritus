package com.greenfoxacademy.frontend.models.checkonwebsite;

public class NumberForUntil {
  private int until;

  public NumberForUntil() {
  }


  public NumberForUntil(int number) {
    this.until = number;
  }

  //csak egy üres konstruktort kell adni neki és ő beleteszi amit kell
 /* public NumberForUntil(int until) {
    this.until = until;
  }*/

  public int getUntil() {
    return until;
  }


  public void setUntil(int until) {
    this.until = until;
  }
}
