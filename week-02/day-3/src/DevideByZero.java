import java.util.Scanner;

public class DevideByZero {
  // Create a function that takes a number
  // divides ten with it,
  // and prints the result.
  // It should print "fail" if the parameter is 0
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int divisor = scanner.nextInt();

    name(divisor);
  }

  public static void name(Integer a) {
    try {
      int result = 10 / a;
      System.out.println(result);
    } catch (ArithmeticException e) {
      System.out.println("fail");
    }
  }
}