package charsequence;

//Check out the CharSequence interface
//Create a Gnirts class implementing this interface
//It should have one String field that can be set via the constructor
//Implementing the interface's methods, always think of the field as if it was backwards,
//so at the second position of "this example" there is a 'p'
//In a main method try out all the methods

public class Gnirts implements CharSequence {
  private String text;

  public Gnirts(String text) {
    this.text = text;
  }

  @Override
  public int length() {
    return text.length();
  }

  @Override
  public char charAt(int index) {
    return text.charAt(text.length() - index - 1);
    //char[] stringChar = text.toCharArray();
    //return stringChar[stringChar.length-index-1];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return text.subSequence(text.length() - end, text.length() - start);
  }

  //private String reverseString(String string) {
  //  char[] stringAsCharArray = string.toCharArray();
  //  StringBuilder sb = new StringBuilder();
  //  for (int i = 0; i < stringAsCharArray.length; i++) {
  //    sb.append(stringAsCharArray[stringAsCharArray.length - i - 1]);
  //  }
  //  return sb.toString();
  //}
}
