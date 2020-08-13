package aircraftcarrier;

public class AircraftCarrierMain {
  public static void main(String[] args) {
    Carrier carrier = new Carrier(2000, 300);

    carrier.addNewAircraft(new F16());
    carrier.addNewAircraft(new F35());
    carrier.addNewAircraft(new F35());
    carrier.addNewAircraft(new F16());

    System.out.println(carrier.getStatus());

    try {
      carrier.fill();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("fill happened");
    System.out.println(carrier.getStatus());

    Carrier carrier1 = new Carrier(100, 10);
    carrier1.addNewAircraft(new F16());
    carrier.fight(carrier1);
    System.out.println("fight happened");
    System.out.println(carrier.getStatus());
  }
}
