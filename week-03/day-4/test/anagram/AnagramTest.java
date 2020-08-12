package anagram;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AnagramTest {

  @Test
  public void isAnagram_TwoStringWhichIsAnagram_ReturnTrue(){
    String input1="béla";
    String input2="léba";
    assertTrue(Anagram.isAnagram(input1, input2));
  }

  @Test
  public void isAnagram_TwoStringWhichIsNotAnagram_ReturnFalse(){
    String input1="zakariás";
    String input2="kismókus";
    assertFalse(Anagram.isAnagram(input1, input2));
  }

}