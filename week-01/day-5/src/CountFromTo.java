import java.util.Scanner;

public class CountFromTo {
  public static void main(String[] args) {

    // Create a program that asks for two numbers
    // If the second number is not bigger than the first one it should print:
    // "The second number should be bigger"
    //
    // If it is bigger it should count from the first number to the second by one
    //

    Scanner scanner = new Scanner(System.in);
    System.out.println("Tell me a number:");
    int firstNumber = scanner.nextInt();
    System.out.println("Tell me a number:");
    int secondNumber = scanner.nextInt();

    if (secondNumber <= firstNumber) {
      System.out.println("The second number should be bigger");
    } else {
      for (int i = firstNumber; i < secondNumber; i++) {
        System.out.println(i);
      }
    }
  }
}
