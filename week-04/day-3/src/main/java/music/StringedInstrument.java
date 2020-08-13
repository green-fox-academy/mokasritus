package main.java.music;

public abstract class StringedInstrument extends Instrument {
  protected int numberOfStrings;

  public abstract String sound();

  @Override
  public void play() {
    System.out.println(
        this.name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound());
  }
}
