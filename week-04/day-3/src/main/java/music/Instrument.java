package main.java.music;

public abstract class Instrument {
  protected String name;

  public abstract void play();

  //protected valami akkor a gyereke látja még ha nem is ugyanabban a package-ben van
  //default package private: csak a package-en belül látható, akkor is ha a gyere de mégis kívül van
}
