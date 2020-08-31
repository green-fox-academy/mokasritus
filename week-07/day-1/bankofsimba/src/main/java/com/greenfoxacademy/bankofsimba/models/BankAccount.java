package com.greenfoxacademy.bankofsimba.models;

public class BankAccount {
  private String name;
  private int balance;
  private String animalType;
  private boolean isKing;

  public boolean isKing() {
    return isKing;
  }

  public void setKing(boolean king) {
    isKing = king;
  }

  public BankAccount(String name, int balance, String animalType, boolean isKing) {
    this.name = name;
    this.isKing = isKing;
    this.balance = balance;
    this.animalType = animalType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }
}
