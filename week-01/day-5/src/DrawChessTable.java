import java.util.Scanner;

public class DrawChessTable {
  public static void main(String[] args) {
    // Crate a program that draws a chess table like this
    //
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %
    // % % % %
    //  % % % %

    Scanner scanner = new Scanner(System.in);
    System.out.println("Tell me a number");
    int number = scanner.nextInt();

    for (int i = 1; i <= number; i++) {
      for (int j = 1; j <= number; j++) {
        if ((i % 2 != 0 && j % 2 != 0) || (i % 2 == 0 && j % 2 == 0)) {
          System.out.print("%");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
