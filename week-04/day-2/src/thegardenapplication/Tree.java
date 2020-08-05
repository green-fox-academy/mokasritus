package thegardenapplication;

public class Tree extends Plant{

  public Tree (String color) {
    super(color);
  }

  /*@Override
  public void needsWaterOrNot() {
    if (needsWater()) {
      System.out.println("The " + super.getColor() +" " +  this.getClass().getSimpleName() + " needs water");
    } else {
      System.out.println("The " + super.getColor() + " " + this.getClass().getSimpleName() + " doesn't need water");
    }
  }*/

  @Override
  public boolean needsWater (){
    return getWaterAmount() < 10;
  }

  @Override
  public void watering(double wateringWaterAmount){
    setWaterAmount(getWaterAmount()+(wateringWaterAmount*0.40));
  }
}
