package com.greenfox.foxclub.repository;

import com.greenfox.foxclub.models.Fox;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository //tárol és hozzáférést biztosít
public class FoxRepository {
  private List<Fox> foxes;

  public FoxRepository() {
    this.foxes = new ArrayList<>();
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  public void save(Fox newFox) {
    foxes.add(newFox);
    //gyakorlatilag itt adjuk hozzá az új rókát és ezt hívjuk meg a service-ben
  }

  public Fox findFoxByName(String name) {
    int foxIndex = 0;
    for (int i = 0; i < foxes.size(); i++) {
      if (foxes.get(i).getName() == name) {
        foxIndex = i;
      }
    }
    return foxes.get(foxIndex);
  }
}
