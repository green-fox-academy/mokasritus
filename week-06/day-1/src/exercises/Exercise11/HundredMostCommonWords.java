package exercises.Exercise11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HundredMostCommonWords {
  public static void main(String[] args) {
    List<String> lines = readFile();
    System.out.println(lines);
    String line = String.join(" ", lines)
        .replaceAll("[,.!?;()\"'0-9-$]", "")
        .replace("[]", "");
    System.out.println(line);

    List<String> words = Arrays.asList(line.split(" "));
    System.out.println(
        words.stream()
            .filter(s -> !s.equals(""))
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(100)
            .collect(Collectors.toList())
    );

  }

  private static List<String> readFile() {
    String fileName = "src\\exercises\\Exercise11\\text.txt";
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(Paths.get(fileName));
    } catch (IOException e) {
      System.out.println("Can't read the file");
    }
    return lines;
  }
}
