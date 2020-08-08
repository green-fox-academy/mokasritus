package hardones;

import java.util.ArrayList;
import java.util.List;

public class ShortThatList {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as parameter
    //  Returns a list where the elements are sorted in ascending numerical order
    //  Make a second boolean parameter, if it's `true` sort that list descending

    //  Example:
    System.out.println(bubble(new int[] {34, 12, 24, 9, 5}));
    //  should print [5, 9, 12, 24, 34]
    System.out.println(advancedBubble(new int[] {34, 12, 24, 9, 5}, true));
    //  should print [34, 24, 12, 9, 5]
  }

  public static List<Integer> bubble(int[] numbers) {
    List<Integer> numberList = new ArrayList<>();
    int temp;
    for (int j = 0; j < numbers.length; j++) {
      for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] > numbers[i + 1]) {
          temp = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = temp;
        }
      }
    }
    for (int number : numbers) {
      numberList.add(number);
    }
    return numberList;
  }

  private static List<Integer> advancedBubble(int[] numbersAdvanced, boolean booleen) {
 /*   List<Integer> numberList = new ArrayList<>();
    int temp;
    if (booleen){
      for (int j = 0; j < numbers.length; j++) {
        for (int i = 0; i < numbers.length - 1; i++) {

          if (numbers[i] < numbers[i + 1]) {
            temp = numbers[i];
            numbers[i] = numbers[i + 1];
            numbers[i + 1] = temp;
          }
        }
      }
      for (int number : numbers) {
        numberList.add(number);
      }
      return numberList;
    }
    return bubble(numbers);*/

    bubble(numbersAdvanced);
    if (booleen) {
      List<Integer> numberListAdvanced = new ArrayList<>();
      int[] temp = new int[numbersAdvanced.length];
      for (int i = numbersAdvanced.length - 1; i > -1; i--) {
        temp[numbersAdvanced.length - i - 1] = numbersAdvanced[i];
      }
      numbersAdvanced = temp;
      for (int numberInAdvanced : numbersAdvanced
      ) {
        numberListAdvanced.add(numberInAdvanced);
      }
      return numberListAdvanced;
    }
    return bubble(numbersAdvanced);
  }
}