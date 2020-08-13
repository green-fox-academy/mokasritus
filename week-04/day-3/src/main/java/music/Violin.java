package main.java.music;

public class Violin extends StringedInstrument {

  public Violin() {
    numberOfStrings = 4;
    name = "Violin";
  }

  public Violin(int numberOfStrings) {
    this.numberOfStrings = numberOfStrings;
    name = "Violin";
  }

  @Override
  public String sound() {
    return "Screech";
  }
}
