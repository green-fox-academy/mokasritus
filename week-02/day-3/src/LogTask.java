import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LogTask {

  // Read all data from 'log.txt'.
// Each line represents a log message from a web server
// Write a function that returns an array with the unique IP adresses.
// Write a function that returns the GET / POST request ratio.

  public static void main(String[] args) {
    String filename = "src\\log.txt";
    System.out.println(getUniqueIPAdresses(filename));
    System.out.println(calculateGetPerPostRatio(filename));
  }

  private static double calculateGetPerPostRatio(String filename) {
    double numberOfGet = 0;
    double numberOfPost = 0;
    List<String> getPerPost = new ArrayList<>();
    List<String> logContent = readFile(filename);
    for (String line: logContent
         ) {
      if (line.contains("GET")) {
        numberOfGet++;
      }else {
        numberOfPost++;
    }
    }return numberOfGet/numberOfPost;
  }

  private static List<String> getUniqueIPAdresses(String filename) {
    List<String> ipAdresses = new ArrayList<>();
    List<String> logContent = readFile(filename);
    for (String line : logContent) {
      ipAdresses.add(line.substring(27, 38));
    }
    return ipAdresses;
  }

  private static List<String> readFile(String filename) {
    Path filepath = Paths.get(filename);
    List<String> logContent = null;
    try {
      logContent = Files.readAllLines(filepath);
    } catch (IOException e) {
      System.out.println("Can not read the file");
    }
    return logContent;
  }
}
