package petrolStation;

public class petrolStationMain {
  public static void main(String[] args) {
    Car car = new Car ();
    Station station= new Station();

    car.setGasAmount(20);
    station.refill(car);
    System.out.println();
  }


}
