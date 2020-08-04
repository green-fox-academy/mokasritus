package thegardenapplication;

public class Flower extends Plant {

  public Flower(String color) {
    super();
  }

  @Override
  public void needsWaterOrNot() {
    if (getWaterAmount() < 5) {
      System.out.println("The " + super.getColor() + this.getClass().getSimpleName() + " needs water");
    } else {
      System.out.println("The " + super.getColor() + this.getClass().getSimpleName() + " doesn't need water");
    }
  }

  @Override
  public void watering(double wateringWaterAmount){
    setWaterAmount(getWaterAmount()+(wateringWaterAmount*0.75));
  }
}
