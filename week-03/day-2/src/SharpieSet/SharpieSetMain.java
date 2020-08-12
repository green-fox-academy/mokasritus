package SharpieSet;

public class SharpieSetMain {
  public static void main(String[] args) {
    SharpieSet sharpieSet = new SharpieSet();
    sharpieSet.addSharpie(new Sharpie("green", 5, 200));
    sharpieSet.addSharpie(new Sharpie("green", 876, 0));
    sharpieSet.addSharpie(new Sharpie("yellow", 8, 12));
    sharpieSet.addSharpie(new Sharpie("purple", 956, 0));
    sharpieSet.addSharpie(new Sharpie("green", 5, 10));

    System.out.println(sharpieSet.countUsable());
    sharpieSet.removeTrash();
    System.out.println(sharpieSet);
  }
}
