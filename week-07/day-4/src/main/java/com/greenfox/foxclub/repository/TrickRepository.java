package com.greenfox.foxclub.repository;

import com.greenfox.foxclub.models.Trick;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TrickRepository {
  private List<Trick> trickList;

  public TrickRepository() {
    this.trickList = new ArrayList<>();
    trickList.add(new Trick("Write HTML"));
    trickList.add(new Trick("Eat cake"));
    trickList.add(new Trick("Watch TV"));
    trickList.add(new Trick("Play tetris"));
  }

  public List<Trick> getTrickList() {
    return trickList;
  }
}
