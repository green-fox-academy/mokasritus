package com.greenfox.foxclub.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Fox {
  private String name;

  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<Trick> tricks;
  private Food food;
  private Drink drink;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne
  private FoxUser foxUser;

  public Fox() {
    this.drink =Drink.chokolatemilk;
    this.food = Food.brownie;
    tricks = new ArrayList<>();
  }

  public Fox(String name) {
    this();
    this.name = name;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }

  public List<Trick> getTricks() {
    return tricks;
  }

  public void setTricks(List<Trick> tricks) {
    this.tricks = tricks;
  }
}

