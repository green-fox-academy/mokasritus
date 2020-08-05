package thegardenapplication;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Plant> plants;

 /* public Garden(List<Plant> plants) {
    this.plants = plants;
  }*/

  public Garden() {
    plants = new ArrayList<>();
  }

  public void watering(double wateringWaterAmount) {
    int sum = 0;
    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).needsWater()) {
        sum++;
      }
    }
    double waterForOnePlant = wateringWaterAmount / sum;
    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).needsWater()) {
        plants.get(i).watering(waterForOnePlant);
      }
    }
  }

  public void addPlant(Plant plant) {
    plants.add(plant);
  }

  public void needsWaterOrNot() {
    for (Plant pl : plants) {
      pl.needsWaterOrNot();
    }
  }
}