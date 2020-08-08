package hardones;

import java.util.Arrays;

public class Anagram {
  //Exercise
  //Create a function named is anagram following your current language's style guide. It should take two strings and return a boolean value depending on whether its an anagram or not.
  //
  //Examples
  //input 1	input 2	output
  //"dog"	"god"	true
  public static void main(String[] args) {
    System.out.println(isAnagram("dog", "fod"));
  }
  public static boolean isAnagram(String input1, String input2){
    char[] fromInput1=input1.toCharArray();
    char[] sortedFromInput1;
    Arrays.sort(fromInput1);
    char[] fromInput2=input2.toCharArray();
    Arrays.sort(fromInput2);
    if (Arrays.equals(fromInput1, fromInput2))
    {return true;}
    else {return false;}
  }
}
