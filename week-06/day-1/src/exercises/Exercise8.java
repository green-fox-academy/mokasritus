package exercises;

//Write a Stream Expression to concatenate
//a Character list to a string!

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise8 {
  public static void main(String[] args) {
    List<Character> characters = Arrays.asList('a', 'l', 'a', 'b', 'a', 's', 't', 'r', 'o', 'm');

  String word =  characters.stream()
      .map(ch->ch.toString())
      .collect(Collectors.joining());

    System.out.println(word);
  }
}
