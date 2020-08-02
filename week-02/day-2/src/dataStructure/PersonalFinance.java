package dataStructure;
//Personal finance
//We are going to represent our expenses in a list containing integers.
//
//Create a list with the following items.
//500, 1000, 1250, 175, 800 and 120
//Create an application which solves the following problems.
//How much did we spend?
//Which was our greatest expense?
//Which was our cheapest spending?
//What was the average amount of our spendings?

import java.util.ArrayList;
import java.util.List;

public class PersonalFinance {
  public static void main(String[] args) {
    ArrayList<Integer> money = new ArrayList<>();
    money.add(500);
    money.add(1000);
    money.add(1250);
    money.add(175);
    money.add(800);
    money.add(120);

    System.out.println(sumMoney(money));
    System.out.println(greatestExpense(money));
    System.out.println(cheapestExpense(money));

    System.out.println(average(money));
  }

  public static int average(ArrayList<Integer> money) {
    return sumMoney(money) / money.size();
  }

 /* public static int average(ArrayList<Integer> money) {
    int sum = 0;
    for (int element : money) {
      sum += element;
    }
    int average;
    average = sum / money.size();
    return average;
  }*/


  private static int cheapestExpense(ArrayList<Integer> money) {
    int cheapest = money.get(0);
    for (int i = 0; i < money.size(); i++) {
      if (money.get(i) < cheapest) {
        cheapest = money.get(i);
      }
    }
    return cheapest;
  }

  private static int greatestExpense(ArrayList<Integer> money) {
    int greatest = 0;
    for (int i = 0; i < money.size(); i++) {
      if (money.get(i) > greatest + 1) {
        greatest = money.get(i);

      }
    }
    return greatest;
  }

  private static int sumMoney(List<Integer> money) {
    int sum = 0;
    for (int element : money) {
      sum += element;
    }
    return sum;
  }
}
