package dojo.getindex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GetIndexTest {

  //Create a function that takes a list and a value, and returns the index of that value in the list.
// If the value is not it the list the function should return -1.
  int[] elements = {1, 3, 78, 876, 5}; //1, 3, 78, 876, 5
  GetIndex getIndex = new GetIndex();

  @Test
  void getIndexTest() {
    assertEquals(4, getIndex.getIndex(elements, 5));
  }

  @Test
  void getIndexForValue3() {
    assertEquals(1, getIndex.getIndex(elements, 3));
  }

  @Test
  void ifValueNotFoundReturnMinusOne() {
    assertEquals(-1, getIndex.getIndex(elements, 11));
  }

  @Test
  void ifArrayIsEmptyReturnProperMessage() {
    int[] emptyArray = {};
    assertEquals(-2, getIndex.getIndex(emptyArray, 11));
  }
}
