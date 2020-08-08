package function;

public class SummingFunction {
  public static void main(String[] args) {
    // Create the usual class wrapper and main method on your own.

    // Write a function called `sum` that returns the sum of numbers from zero to the given parameter

    System.out.println(sum(5));
  }

  public static int sum(int x) {
    if (x == 0) {
      return 0;
    }
    return x + sum(x - 1);
  }
}

