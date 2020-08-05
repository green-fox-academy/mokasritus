package charsequence;

//Create a Shifter class implementing this interface
//This charsequence can be set up with a string (that is to be shifted)
//and a number (which will tell how many to shift)
//Implement the methods so the returned results of them will be shifted

public class Shifter implements CharSequence {
  private String text;

  public Shifter(String text, int shifter) {

    this.text = shifter(text, shifter);
    System.out.println(this.text);
  }

  @Override
  public int length() {
    return text.length();
  }

  @Override
  public char charAt(int index) {
    return text.charAt(index);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return text.subSequence(start, end);
  }

  public String shifter(String text, int shifter) {
    String shiftedString;
    String beforeShifter;
    String afterShifter;
    beforeShifter = text.substring(0, shifter);
    afterShifter = text.substring(shifter);
    return shiftedString = afterShifter.concat(beforeShifter);
  }
}
