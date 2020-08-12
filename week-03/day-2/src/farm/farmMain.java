package farm;

public class farmMain {
  public static void main(String[] args) {
    Farm farm = new Farm();
    Animal animal1 = new Animal(40);
    Animal animal2 = new Animal(4);
    Animal animal3 = new Animal(11);
    Animal animal4 = new Animal(78);
    farm.breed(animal1);
    farm.breed(animal2);
    farm.breed(animal3);
    farm.breed(animal4);
    farm.printFarm();
    farm.slaughter();
    farm.printFarm();
    System.out.println(farm.getSlots());

  }
}
