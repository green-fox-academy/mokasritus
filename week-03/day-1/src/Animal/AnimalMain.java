package Animal;

public class AnimalMain {
  public static void main(String[] args) {
  Animal animal1 = new Animal();
    animal1.drink();
    System.out.println(animal1.getThirst());
    animal1.play();
    System.out.println(animal1.getThirst()+" "+animal1.getHunger());

  }
}
