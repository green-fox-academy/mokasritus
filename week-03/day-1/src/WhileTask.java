import java.util.Scanner;

public class WhileTask {
  public static void main(String[] args) {

    String a = "valami";
    boolean name = true;
    Scanner scanner = new Scanner(System.in);
    while (name) {
      System.out.println(3);

      String b = scanner.nextLine();
      if (b.equals("oke")) {
        name = false;
      }
    }
  }
}

