package thegardenapplication;

import java.sql.SQLOutput;

public class Main {
  public static void main(String[] args) {
    Garden garden = new Garden();
    garden.addPlant(new Flower("yellow"));
    garden.addPlant(new Flower("blue"));
    garden.addPlant(new Tree("purple"));
    garden.addPlant(new Tree("orange"));

    garden.needsWaterOrNot();

    garden.watering(40d);
    garden.needsWaterOrNot();

    garden.watering(70d);
    garden.needsWaterOrNot();
  }
}
