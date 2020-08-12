package countletters;

//Write a function, that takes a string as an argument and returns a dictionary with all letters in the string as keys, and numbers as values that shows how many occurrences there are.
//Create a test for that.

import java.util.HashMap;

public class CountLetters {
  public static void main(String[] args) {
    System.out.println(countLetters(""));
  }

  public static HashMap<Character, Integer> countLetters(String string) {
    char[] letters = string.toCharArray();
    int value = 1;
    HashMap<Character, Integer> dictionary = new HashMap<>();
    for (char letter : letters
    ) {
      if (dictionary.containsKey(letter)) {
        value++;
        dictionary.replace(letter, value);
      } else {
        value = 1;
        dictionary.put(letter, value);
      }
    }
    return dictionary;
  }
}
