package thegardenapplication;

public class Tree extends Plant{

  public Tree (String color) {
    super();
  }

  @Override
  public void needsWaterOrNot() {
    if (getWaterAmount() < 10) {
      System.out.println("The " + super.getColor() + this.getClass().getSimpleName() + " needs water");
    } else {
      System.out.println("The " + super.getColor() + this.getClass().getSimpleName() + " doesn't need water");
    }
  }


}
