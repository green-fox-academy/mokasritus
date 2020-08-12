package anagram;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AnagramTest {

  @Test
  public void isAnagram_TwoStringWhichIsAnagram_ReturnTrue(){
    String input1="béla";
    String input2="léba";
    assertTrue(Anagram.isAnagram(input1, input2));
  }

}