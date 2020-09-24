package com.greenfox.foxclub.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FoxUser {
  private String username;
  private String password;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne (cascade = CascadeType.PERSIST)
  private Fox fox;

  public FoxUser() {
  }

  public FoxUser(String username, String password, Fox fox) {
    this();
    this.fox=fox;
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public long getId() {
    return id;
  }

  public Fox getFox() {
    return fox;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFox(Fox fox) {
    this.fox = fox;
  }
}
