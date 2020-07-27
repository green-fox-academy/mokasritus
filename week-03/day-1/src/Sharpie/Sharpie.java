package Sharpie;

public class Sharpie {
private String color;
private float width;
private float inkAmount;

public Sharpie (String color, float width){
  this.color = color;
  this.width = width;
  this.inkAmount = 100;
}

public void use () {
  ++ inkAmount;
}

  public String getColor() {
    return color;
  }

  public float getInkAmount() {
    return inkAmount;
  }

  public float getWidth() {
    return width;
  }
}
