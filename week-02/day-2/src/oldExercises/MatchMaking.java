package oldExercises;

import java.util.ArrayList;
import java.util.Arrays;

public class MatchMaking {
  public static void main(String... args) {
    ArrayList<String>
        girls = new ArrayList<String>(Arrays.asList("Eve", "Ashley", "Claire", "Kat", "Jane"));
    ArrayList<String> boys =
        new ArrayList<String>(Arrays.asList("Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"));

    // Write a method that joins the two lists by matching one girl with one boy into a new list
    // If someone has no pair, he/she should be the element of the list too
    // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

    System.out.println(makingMatches(girls, boys));
  }

  private static ArrayList<String> makingMatches(ArrayList<String> girls, ArrayList<String> boys) {
    ArrayList<String> girlsAndBoys = new ArrayList<>();
    if (boys.size() > girls.size()) {
      for (int j = 0; j < girls.size(); j++) {
        girlsAndBoys.add(girls.get(j));
        girlsAndBoys.add(boys.get(j));
      }
      for (int i = girls.size(); i < boys.size(); i++) {
        girlsAndBoys.add(boys.get(i));
      }
    } else if (boys.size() < girls.size()) {
      for (int j = 0; j < boys.size(); j++) {
        girlsAndBoys.add(girls.get(j));
        girlsAndBoys.add(boys.get(j));
      }
      for (int i = boys.size(); i < girls.size(); i++) {
        girlsAndBoys.add(girls.get(i));
      }
    }
    return girlsAndBoys;
  }
}