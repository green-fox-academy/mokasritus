package Exercises.duplicatedchars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DuplicatedChars {
  public static void main(String[] args) {
    singleChars("Exercises\\duplicatedchars\\duplicated-chars.txt");
  }

  private static void singleChars(String path) {
    Path filePath = Paths.get(path);
    String temph = "";
    List<String> allLines = null;
    List<String> singleChars = new ArrayList();
    try {
      allLines = Files.readAllLines(filePath);
    } catch (Exception e) {
      e.printStackTrace();
    }
    for (String line : allLines
    ) {
      for (int i = 0; i < line.length()-1; i++) {
        if (line.charAt(i) == line.charAt(i + 1)) {
          temph+=line.charAt(i);

        }
      }temph+="\n";
    }
    singleChars.add(temph);
    try {
      Files.write(filePath, singleChars);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
