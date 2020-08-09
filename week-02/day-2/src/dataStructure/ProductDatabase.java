package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {

  //Create a map with the following key-value pairs.
  //
  //Product name (key)	Price (value)
  //Eggs	200
  //Milk	200
  //Fish	400
  //Apples	150
  //Bread	50
  //Chicken	550
  //Create an application which solves the following problems.
  //
  //How much is the fish?
  //What is the most expensive product?
  //What is the average price?
  //How many products' price is below 300?
  //Is there anything we can buy for exactly 125?
  //What is the cheapest product?

  public static void main(String[] args) {
    HashMap<String, Integer> database = new HashMap<>();
    database.put("Eggs", 200);
    database.put("Milk", 200);
    database.put("Fish", 400);
    database.put("Apples", 150);
    database.put("Bread", 50);
    database.put("Chicken", 550);

    System.out.println(priseOf(database, "Fish"));
    System.out.println(theMostExpensiveProduct(database));
    System.out.println(avaragePrice(database));
    System.out.println(pruductsNumberBelow(database, 300));
    System.out.println(isThereSomethingfor(database, 125));
    System.out.println(whichIsTheCheapestProduct(database));
  }

  private static String whichIsTheCheapestProduct(HashMap<String, Integer> database) {
    String cheapestProduct = "";
    int cheapestProductPrice = Integer.MAX_VALUE;
    for (Map.Entry<String, Integer> entry : database.entrySet()) {
      if (entry.getValue() < cheapestProductPrice) {
        cheapestProduct = entry.getKey();
        cheapestProductPrice = entry.getValue();
      }
    } return "The cheapest product is: " + cheapestProduct;
  }


  private static String isThereSomethingfor(HashMap<String, Integer> database, int price) {
    ArrayList<Integer> values = createValueList(database);
    for (int i = 0; i < values.size() - 1; i++) {
      if (values.get(i) <= price) {
        return "Yes";
      }
    }
    return "No";
  }

  private static int pruductsNumberBelow(HashMap<String, Integer> database, int below) {
    int productsNumber = 0;
    for (Map.Entry<String, Integer> entry : database.entrySet()) {
      if (entry.getValue() < (below)) {
        productsNumber++;
      }
    }
    return productsNumber;
  }

  private static int avaragePrice(HashMap<String, Integer> database) {
    int sum = 0;
    ArrayList<Integer> values = createValueList(database);
    for (int i = 0; i < values.size() - 1; i++) {
      sum += values.get(i);
    }
    return sum / values.size();
  }

  private static String theMostExpensiveProduct(HashMap<String, Integer> database) {
    int maxPrice = 0;
    String productNameMaxPrice = null;
    ArrayList<Integer> values = createValueList(database);
    for (int i = 0; i < values.size() - 1; i++) {
      if (values.get(i) < values.get(i + 1)) {
        maxPrice = values.get(i + 1);
      }
    }
    for (Map.Entry<String, Integer> entry : database.entrySet()) {
      if (entry.getValue().equals(maxPrice)) {
        productNameMaxPrice = entry.getKey();
        break;
      }
    }
    return "The most expensive product is " + productNameMaxPrice;
  }

  private static ArrayList<Integer> createValueList(HashMap<String, Integer> database) {
    ArrayList<Integer> values = new ArrayList<>();
    for (int value : database.values()) {
      values.add(value);
    }
    return values;
  }


  private static String priseOf(HashMap<String, Integer> database, String productName) {
    return "The " + productName + " is: " + database.get(productName);
  }
}
