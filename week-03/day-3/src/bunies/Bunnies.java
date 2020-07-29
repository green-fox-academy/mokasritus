package bunies;

/*We have a number of bunnies and each bunny has two big floppy ears. We want to
compute the total number of ears across all the bunnies recursively
(without loops or multiplication).*/

public class Bunnies {
  public static void main(String[] args) {
    System.out.println(totalNumberOfEars(3));
  }

  public static int totalNumberOfEars(int n) {
    int earsOfOneBunny = 2;
    if (n == 0) {
      return 0;
    } else {
      return earsOfOneBunny + totalNumberOfEars(
          n - 1); // a lépések száma és minden lépésben hozzáadok plusz 2 nyuszifület
    }
  }
}
