package Exercises.reversedlinestask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {

  public static void main(String[] args) {
    // Create a method that decrypts reversed-lines.txt
    reverseLines("src/Exercises.reversedlinestask/Reversed-lines.txt");
  }

  public static void reverseLines(String file) {
    Path filePath = Paths.get(file);
    String temph = "";
    List<String> allLines = null;
    List<String> reversedLines = new ArrayList();
    try {
      allLines = Files.readAllLines(filePath);
    } catch (Exception e) {
      e.printStackTrace();
    }
    for (String line : allLines
    ) {
      line+="\n";
      for (int i = line.length() - 1; i >= 0; i--) {
        temph += line.charAt(i);
      }
    }
    reversedLines.add(temph);
    try {
      Files.write(filePath, reversedLines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

