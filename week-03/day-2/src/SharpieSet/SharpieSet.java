package SharpieSet;

import java.util.ArrayList;
import java.util.List;

//Reuse your Sharpie class
//Create SharpieSet class
//it contains a list of Sharpie
//countUsable() -> sharpie is usable if it has ink in it
//removeTrash() -> removes all unusable sharpies

public class SharpieSet {
  private List<Sharpie> sharpieSet = new ArrayList<Sharpie>();

  public SharpieSet() {
  }

  public void addSharpie(Sharpie sharpie) {
    this.sharpieSet.add(sharpie);
  }

  public int countUsable() {
    int numberOfUsableSharpie = 0;
    for (Sharpie sharpie : sharpieSet
    ) {
      if (sharpie.isUseable()) {
        numberOfUsableSharpie++;
      }
    }
    return numberOfUsableSharpie;
  }

  public void removeTrash() {
    List<Sharpie> afterRemoveTrash = new ArrayList<>();
    for (Sharpie sharpie : sharpieSet
    ) {
      if (sharpie.isUseable()) {
        afterRemoveTrash.add(sharpie);
      }
    }
    sharpieSet = afterRemoveTrash;
  }
}
