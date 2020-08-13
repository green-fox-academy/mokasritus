package main.java.music;

public class ElectricGuitar extends StringedInstrument {

  public ElectricGuitar() {
    numberOfStrings = 6;
    name = "Electric Guitar";
  }

  public ElectricGuitar(int numberOfStrings){
    this.numberOfStrings=numberOfStrings;
    name = "Electric Guitar";
  }

  @Override
  public String sound() {
   return "Twang";
  }
}
