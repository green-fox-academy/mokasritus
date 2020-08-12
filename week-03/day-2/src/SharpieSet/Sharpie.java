package SharpieSet;

//Create Sharpie class
//We should know about each sharpie their color (which should be a string), width (which will be a floating point number),
//inkAmount (another floating point number)
//When creating one, we need to specify the color and the width
//Every sharpie is created with a default 100 as inkAmount
//We can use() the sharpie objects
//which decreases inkAmount

public class Sharpie {
  private String color;
  private float width;
  private float inkAmount;

  public Sharpie(String color, float width, float inkAmount) {
    this.color = color;
    this.width = width;
    this.inkAmount = inkAmount;
  }

  public void use() {
    ++inkAmount;
  }

  public boolean isUseable() {
    if (inkAmount > 0) {
      return true;
    } else {
      return false;
    }
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