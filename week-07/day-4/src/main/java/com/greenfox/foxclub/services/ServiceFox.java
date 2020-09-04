package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Fox;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServiceFox{
  private List<Fox> foxes;


  public ServiceFox() {
    this.foxes = new ArrayList<>();
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  public void setFoxes(List<Fox> foxes) {
    this.foxes = foxes;
  }

  public void addFox(String name){
    foxes.add(new Fox(name));
  }

}
