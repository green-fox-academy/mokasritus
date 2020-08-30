package exercises.Exercise10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoxMain {
  public static void main(String[] args) {
    List<Fox> foxes = new ArrayList<>();

    Fox fox1 = new Fox("Bela", "green", 20);
    Fox fox2 = new Fox("Kazmer", "blue", 40);
    Fox fox3 = new Fox("Zaki", "yellow", 5);
    Fox fox4 = new Fox("Gazsika", "green", 1);
    Fox fox6 = new Fox("Gazsi", "green", 15);
    Fox fox5 = new Fox("Erzsi", "orange", 1);

    foxes.add(fox1);
    foxes.add(fox2);
    foxes.add(fox3);
    foxes.add(fox4);
    foxes.add(fox5);
    foxes.add(fox6);

    List<Fox> greenFoxes = foxes.stream()
        .filter(fox -> fox.color.equals("green"))
        .collect(Collectors.toList());
    System.out.println(greenFoxes);

    List<Fox> greenFoxesOlderThanFiveYearsOld = foxes.stream()
        .filter(fox -> fox.color.equals("green") && fox.age > 5)
        .collect(Collectors.toList());
    System.out.println(greenFoxesOlderThanFiveYearsOld
    );

    Map<String, Long> frequencyByColor = foxes.stream()
        .collect(Collectors.groupingBy(fox -> fox.color, Collectors.counting()));
    System.out.println(frequencyByColor);

  }
}
