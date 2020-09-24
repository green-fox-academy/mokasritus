package com.greenfox.foxclub.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Trick {
  private String name;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @ManyToMany
  private List<Fox> foxes;

  public Trick() {
  }

  public Trick(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


  public List<Fox> getFoxes() {
    return foxes;
  }

  public void setFoxes(List<Fox> foxes) {
    this.foxes = foxes;
  }
}
