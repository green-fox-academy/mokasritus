import java.util.Scanner;

public class MultiplicationTable {
  public static void main(String[] args) {
    // Create a program that asks for a number and prints the multiplication table with that number
    Scanner scanner = new Scanner(System.in);
    System.out.println("Tell me a number:");
    int number = scanner.nextInt();

    for (int i = 1; i < 11; i++) {
      System.out.println(i + " * " + number + " = " + i * number);
    }
  }
}
