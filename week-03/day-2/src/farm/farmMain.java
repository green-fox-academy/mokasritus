package farm;

public class farmMain {
  public static void main(String[] args) {
    Farm farm = new Farm();
    farm.breed();
    farm.breed();
    farm.breed();
    farm.breed();
    farm.slaughter();
    farm.printFarm();
    System.out.println(farm.getSlots());

  }
}
