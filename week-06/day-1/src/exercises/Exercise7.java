package exercises;

//Write a Stream Expression to find the strings which starts
//with a given letter(as parameter), in the following list:

import java.util.Arrays;
import java.util.List;

public class Exercise7 {
  public static void main(String[] args) {
    List<String>
        cities = Arrays
        .asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM",
            "ABU DHABI", "PARIS");

    String letter = "N";

    searchCities(cities, letter);

  }

  private static void searchCities(List<String> cities, String letter) {
    cities.stream()
        .filter(city -> city.startsWith(letter))
        .forEach(System.out::println);
  }
}
