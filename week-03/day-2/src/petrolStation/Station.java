package petrolStation;
/*Station
gasAmount
refill(car) -> decreases the gasAmount by the capacity of the car and increases the cars gasAmount*/

public class Station {
  private int gasAmount;

  public Station() {
    this.gasAmount = 800;
  }

  public void refill (Car car) {
    this.gasAmount-=car.getCapacity();
    car.setGasAmount(car.getCapacity()-car.getGasAmount()); // car.setGasAmount()--> ezzel állítom át a GasAmount értékét és a zárójelen belül kell megadnom hogy hogyan kapom meg az értékét(számítási módot
  }
}
