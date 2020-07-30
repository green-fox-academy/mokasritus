package apples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplesTest {


  @Test
  void getAnApple() {
    Apples apple1 = new Apples();
    assertEquals("apple", apple1.getAnApple());
  }
}