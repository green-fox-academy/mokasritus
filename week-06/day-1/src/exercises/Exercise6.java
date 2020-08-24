package exercises;

//Write a Stream Expression to find the
//uppercase characters in a string!

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise6 {
  public static void main(String[] args) {
    String findUpperCaseLetters = "AbnvK";


    String upperCaseLetter= findUpperCaseLetters.chars()
        .filter(Character::isUpperCase)
        .mapToObj(charact->Character.toString((char)charact))
        .collect(Collectors.joining());

    System.out.println(upperCaseLetter);
  }
}
