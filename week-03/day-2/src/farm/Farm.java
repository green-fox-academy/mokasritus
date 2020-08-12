package farm;

//Reuse your Animal class
//Create a Farm class
//  it has list of Animals
//  it has slots which defines the number of free places for animals
//  breed() -> creates a new animal if there's place for it
//  slaughter() -> removes the least hungry animal

import java.util.ArrayList;
import java.util.List;

public class Farm {
  private List<Animal> farm = new ArrayList<>();
  private int slots;

  public Farm() {
    slots = 4;
  }

  public void breed(Animal animal) {
    if (slots > 0) {
      farm.add(animal);
      slots--;
      System.out.println("New animal breed");
    } else {
      System.out.println("There is no place for a new animal");
    }
  }

  public void slaughter() {
    int leastHungry = 100;
    int indexOfLeastHungry = 0;
    for (int j = 0; j < farm.size() - 1; j++) {
      for (int i = 0; i < farm.size() - 1; i++) {
        if (farm.get(i).getHunger() < leastHungry) {
          leastHungry = farm.get(i).getHunger();
          indexOfLeastHungry = farm.indexOf(farm.get(i));
        }
      }
    }
    farm.remove(indexOfLeastHungry);
    slots++;
  }

  public int getSlots() {
    return slots;
  }

  public void printFarm() {
    for (Animal animal : farm
    ) {
      System.out.println(animal.toString());
    }
  }
}
