package exercises;

//Write a Stream Expression to find the frequency
//of characters in a given string!

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.stream.Collectors;

public class Exercise9 {
  public static void main(String[] args) {
    String letters = "ezkellafeladathoz";

    Map<Character, Integer> frequencyOfCharacters = letters.chars().boxed()
        .collect(toMap(
            key-> (char) key.intValue(),
            value->1,
            Integer::sum));
    System.out.println(frequencyOfCharacters);
  }
}
