import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
  // Write a function that takes a filename as string,
  // then returns the number of lines the file contains.
  // It should return zero if it can't open the file, and
  // should not raise any error.
  public static void main(String[] args) {
    countLines("my-file.txt");
  }

  public static void countLines(String fileName) {
    try {
      Path filePath = Paths.get(fileName);
      List<String> allLines = Files.readAllLines(filePath);
      int returns = allLines.size();
      System.out.println(returns);
    } catch (IOException e) {
      System.out.println("zero");
    }
  }
}

