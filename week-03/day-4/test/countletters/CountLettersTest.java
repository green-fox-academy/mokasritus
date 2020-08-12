package countletters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class CountLettersTest {

  @Test
  void main() {
  }

  @Test
  void countLetters_withString_returnEquals() {
    String string = "rita";
    HashMap<Character, Integer> dictrionary = new HashMap<>();
    dictrionary.put('r', 1);
    dictrionary.put('i', 1);
    dictrionary.put('t', 1);
    dictrionary.put('a', 1);
    assertEquals(dictrionary, CountLetters.countLetters(string));
  }

  @Test
  void countLetters_withEmptyString_returnEquals() {
    String string = "";
    HashMap<Character, Integer> dictrionary = new HashMap<>();
    assertEquals(dictrionary, CountLetters.countLetters(string));
  }
}