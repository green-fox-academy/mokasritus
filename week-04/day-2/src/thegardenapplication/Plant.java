package thegardenapplication;

public class Plant {
  private String color;
  private double waterAmount;

  public Plant(String color) {
    this.color = color;
    this.waterAmount = 0;
  }

  public String getColor() {
    return color;
  }

  public void setWaterAmount(double waterAmount) {
    this.waterAmount = waterAmount;
  }

  public double getWaterAmount() {
    return waterAmount;
  }

  public boolean needsWater() {
    return true;
  }

  public void needsWaterOrNot() {
    if (needsWater()) {
      System.out
          .println("The " + this.color + " " + this.getClass().getSimpleName() + " needs water");
    } else {
      System.out.println(
          "The " + this.color + " " + this.getClass().getSimpleName() + " doesn't need water");
    }
  }

  public void watering(double wateringWaterAmount) {
    this.waterAmount += wateringWaterAmount;
  }


}
