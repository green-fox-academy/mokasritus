package com.greenfox.foxclub.repository;

import com.greenfox.foxclub.models.Fox;
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

  public Trick findTrickByName(String trickToLearn) {
    int trickIndex = 0;
    for (int i = 0; i < trickList.size(); i++) {
      if (trickList.get(i).getName().equals(trickToLearn)) {
        trickIndex = i;
      }
    }
    return trickList.get(trickIndex);
  }
}
