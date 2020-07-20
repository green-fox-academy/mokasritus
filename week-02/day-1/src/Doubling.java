public class Doubling {
  public static void main(String[] args) {

// - Create an integer variable named `baseNum` and assign the value `123` to it
// - Create a function called `doubling` that doubles it's input parameter and returns with an integer
// - Print the result of `doubling(baseNum)`
    int baseNum = 123;
    System.out.println(doubling(baseNum));

  }

  public static int doubling (int num) { // változónak csak azt definiálom, amit a függvényben használok
    return num *2; // integer esetén az eredményt meg kell hívni return-nel, de ide elegendő beírni a számítást
  }
}
