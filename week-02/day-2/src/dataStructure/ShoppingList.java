package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//We are going to represent a shopping list in a list containing strings.
//
//Create a list with the following items.
//Eggs, milk, fish, apples, bread and chicken
//Create an application which solves the following problems.
//Do we have milk on the list?
//Do we have bananas on the list?
public class ShoppingList {
  public static void main(String[] args) {
    String[] things = {"eggs", "milk", "fish", "apples", "bread", "chicken"};
    List<String> shoppingList = new ArrayList<>();
    shoppingList = Arrays.asList((things));

    System.out.println(doWeHave(shoppingList, "milk"));
    System.out.println(doWeHave(shoppingList, "bananas"));
  }

  private static String doWeHave(List<String> shoppingList, String thing) {
    for (String thingOnTheList : shoppingList
    ) {
      if (thingOnTheList.equals(thing)) {
        return "Yes";
      }
    }
    return "No";
  }
}
