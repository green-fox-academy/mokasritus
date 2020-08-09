package oldExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppendLetter {
  public static void main(String... args) {
    List<String> far = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
    // Create a method called "appendA()" that adds "a" to every string in the "far" list.
    // The parameter should be a list.

    System.out.println(appendA(far));
  }

  private static List<String> appendA(List<String> far) {
    List<String> appendedA = new ArrayList<>();
    String append = "a";
    String oneElementInAppendedA;
    for (String element : far
    ) {
      oneElementInAppendedA = element.concat(append);
      appendedA.add(oneElementInAppendedA);
    } return appendedA;
  }
}

// The output should be: "boa", "anaconda", "koala", "panda", "zebra"

