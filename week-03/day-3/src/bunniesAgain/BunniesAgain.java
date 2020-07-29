package bunniesAgain;

/*We have bunnies standing in a line, numbered 1, 2, ...
The odd bunnies (1, 3, ..) have the normal 2 ears.
The even bunnies (2, 4, ..) we'll say have 3 ears,
because they each have a raised foot.
Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).*/

public class BunniesAgain {
  public static void main(String[] args) {
    System.out.println(totalEarsOfBunnies(5));
  }

  public static int totalEarsOfBunnies(int numberOfBunnies) {
    int earsNumbOddBunnies = 2;
    int earsNumbEvenBunnies = 3;
    if (numberOfBunnies == 0) {
      return 0;
    } else if (numberOfBunnies % 2 == 0) {
        return earsNumbEvenBunnies + totalEarsOfBunnies(numberOfBunnies - 1);
      } else {
        return earsNumbOddBunnies + totalEarsOfBunnies(numberOfBunnies - 1);
      }
    }
  }

