package anagram;

import java.util.Arrays;

//Write a function, that takes two strings and returns a boolean value based on
//if the two strings are Anagramms or not.
//Create a test for that.

public class Anagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("béla", "léba"));
  }

  public static boolean isAnagram(String input1, String input2) {
    char[] fromInput1 = input1.toCharArray();
    char[] fromInput2 = input2.toCharArray();
    Arrays.sort(fromInput1);
    Arrays.sort(fromInput2);
    if (Arrays.equals(fromInput1, fromInput2)) {
      return true;
    } else {
      return false;
    }
  }
}
