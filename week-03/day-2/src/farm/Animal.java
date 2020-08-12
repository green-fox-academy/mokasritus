package farm;

public class Animal {
  private int hunger;
  private int thirst;

  public Animal(int hunger) {
    this.hunger=hunger;
    this.thirst = 50;
  }
  public void eat () {
    --hunger;
  }

  public void drink() {
    --thirst;
  }

  public void play() {
    ++hunger;
    ++thirst;
  }

  public int getHunger() {
    return hunger;
  }

  public int getThirst() {
    return thirst;
  }
}