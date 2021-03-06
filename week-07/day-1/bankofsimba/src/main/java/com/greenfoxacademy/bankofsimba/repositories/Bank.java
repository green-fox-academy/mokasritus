package com.greenfoxacademy.bankofsimba.repositories;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import java.util.ArrayList;
import java.util.List;

//Create an List of BankAccounts and fill them with 4-5 characters (from the movie)

public class Bank {
  private List<BankAccount> bankAccounts;

  public Bank() {
    bankAccounts = new ArrayList<>();

    bankAccounts.add(new BankAccount("Pumba", 300, "wharthog", false));
    bankAccounts.add(new BankAccount("Timon", 1500, "african meerkat", false));
    bankAccounts.add(new BankAccount("Musfasa", 1000, "lion", true));
    bankAccounts.add(new BankAccount("Kamari", 700, "Hyena", false));
    bankAccounts.add(new BankAccount("Azizi", 700, "Hyena", false));
  }

  public List<BankAccount> getBankAccounts() {
    return bankAccounts;
  }

  public void setBankAccounts(
      List<BankAccount> bankAccounts) {
    this.bankAccounts = bankAccounts;
  }

  public void addBankAccounts(BankAccount bankAccount){
    this.bankAccounts.add(bankAccount);
  }
}
