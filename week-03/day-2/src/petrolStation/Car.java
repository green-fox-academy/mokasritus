package petrolStation;

/*gasAmount
capacity
create constructor for Car where:
initialize gasAmount -> 0
initialize capacity -> 100    */

public class Car {
  private int gasAmount;
  private int capacity;

  public Car() {
    this.gasAmount=0;
    this.capacity=100;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getGasAmount() {
    return gasAmount;
  }

  public void setGasAmount(int gasAmount) {
    this.gasAmount = gasAmount;
  }
}
