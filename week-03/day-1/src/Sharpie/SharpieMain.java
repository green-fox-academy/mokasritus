package Sharpie;

public class SharpieMain {
  public static void main(String[] args) {
    Sharpie bela = new Sharpie("keki", 1.0342f);
    System.out.println(bela.getColor()+" "+bela.getWidth()+" "+bela.getInkAmount());

    bela.use();
    System.out.println(bela.getColor()+" "+bela.getWidth()+" "+bela.getInkAmount());
  }
}
