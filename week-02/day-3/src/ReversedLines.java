import java.util.ArrayList;
import java.util.List;

public class ReversedLines {

  public static void main(String[] args) {
    // Create a method that decrypts reversed-lines.txt

    reverseLines("Reversed-lines.txt");

  }

  public static void reverseLines(String file) {
    try {
      List<String> content = new ArrayList();
      for (int i = 0; i < content.size(); i++) {
        String m = "";
        for (int j = content.size() - 1; j >= 0; j--) {
          m = m += content
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
