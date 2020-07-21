public class ToDoPrint {
  public static void main(String... args){
    String todoText = " - Buy milk\n";
    // Add "My todo:" to the beginning of the todoText
    String start = ("My todo:\n");
    String games = (" - Dowload games\n \t - Diablo");
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention

    // Expected output:

    // My todo:
    //  - Buy milk
    //  - Download games
    //      - Diablo
    String todoText1 = start.concat(todoText).concat(games);
    System.out.println(todoText1);
  }
}
