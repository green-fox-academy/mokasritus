package sum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SumTest {
  private static Sum sum;
  private static ArrayList<Integer> elements;
  private static ArrayList<Integer> elements2;

  @BeforeAll
  public static void setUp() {
    elements = new ArrayList<>();
    sum = new Sum(elements);
  }

  @Test
  void test1() {
    int a = (int) (1 + Math.random() * 100);
    elements.add(a);
    int b = (int) (1 + Math.random() * 100);
    elements.add(b);
    int c = (int) (1 + Math.random() * 100);
    elements.add(c);

    assertEquals(a + b + c, Sum.sumElements(elements));
  }

  @Test
  void test2() {
    assertEquals(0, Sum.sumElements(elements));
  }

  @Test
  void test3() {
    int a = (int) (1 + Math.random() * 100);
    elements.add(a);
    assertEquals(a, Sum.sumElements(elements));
  }
  @Test
  void test4() {
    elements2 = null;
    assertNull(Sum.sumElements(elements2));
  }
}