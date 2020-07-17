import java.util.Scanner;

public class GuessTheNumber {
  public static void main(String[] args) {
    // Write a program that stores a number, and the user has to figure it out.
    // The user can input guesses, after each guess the program would tell one
    // of the following:
    //
    // The stored number is higher
    // The stried number is lower
    // You found the number: 8

    int storedNumber = 8;

    //  for (int i = 0; i < 100; i++) {
    //    Scanner scanner = new Scanner(System.in);
    //    System.out.println("Tell me your guess:");
    //    int guess = scanner.nextInt();
    //    if (storedNumber < guess) {
    //      System.out.println("The stored number is lower");
    //    } else if (storedNumber > guess) {
    //      System.out.println("The stored number is higher");
    //    } else {
    //      System.out.println("You found the number: " + storedNumber);
    //      break;
    //    }
//    }
// }
//}
//}
    int i = 0;
    do {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Tell me your guess:");
      int guess = scanner.nextInt();
      if (storedNumber < guess) {
        System.out.println("The stored number is lower");
      } else if (storedNumber > guess) {
        System.out.println("The stored number is higher");
      } else {
        System.out.println("You found the number: " + storedNumber);
        break;
        i++;
      }
      while (storedNumber == guess);
    }
  }
}