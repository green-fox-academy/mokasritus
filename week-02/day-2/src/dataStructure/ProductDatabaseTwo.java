package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Create an application which solves the following problems.
//
//Which products cost less than 201? (just the name)
//Which products cost more than 150? (name + price)

public class ProductDatabaseTwo {
  public static void main(String[] args) {
    HashMap<String, Integer> database = new HashMap<>();
    database.put("Eggs", 200);
    database.put("Milk", 200);
    database.put("Fish", 400);
    database.put("Apples", 150);
    database.put("Bread", 50);
    database.put("Chicken", 550);

    System.out.println(whichProductIsCheaperThen(database, 201));
    System.out.println(whichProductCostMore(database, 150));
  }

  private static HashMap<String, Integer> whichProductCostMore(HashMap<String, Integer> database, int limit) {
    HashMap<String, Integer> costMoreThenTheLimit = new HashMap<>();
    for (Map.Entry<String, Integer> entry: database.entrySet()
         ) {
      if (entry.getValue()>limit){
        costMoreThenTheLimit.put(entry.getKey(),entry.getValue());
      }
    }return costMoreThenTheLimit;
  }

  private static List<String> whichProductIsCheaperThen(HashMap<String, Integer> database, int limit) {
    List<String> cheaperProducts = new ArrayList<>();
    for (Map.Entry<String, Integer> entry: database.entrySet()
         ) {
      if (entry.getValue()<limit){
        cheaperProducts.add(entry.getKey());
      }
    }return cheaperProducts;
  }
}
