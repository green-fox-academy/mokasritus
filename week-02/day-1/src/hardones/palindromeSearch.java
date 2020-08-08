package hardones;

import java.util.ArrayList;

public class palindromeSearch {
  //Create a function named search palindrome following your current language's style guide.
  // It should take a string, search for palindromes that at least 3 characters long and return a list with the found palindromes.
  //
  //Examples
  //input	output
  //"dog goat dad duck doodle never"	["og go", "g g", " dad ", "dad", "d d", "dood", "eve"]
  //"apple"	[]
  //"racecar"	["racecar", "aceca", "cec"]
  //""	[]
  public static void main(String[] args) {
    String input1 = "dog goat dad duck doodle never";
    String input2 = "racecar";
    String input3 = "apple";

    System.out.println(searchPalindroms(input1));
    System.out.println(searchPalindroms(input2));
    System.out.println(searchPalindroms(input3));

    System.out.println(isPalindrome("dad"));
  }

  public static ArrayList<String> searchPalindroms(String input) {
    ArrayList<String> polindroms = new ArrayList<>();
    String partOfInput;
    for (int i = 0; i <= input.length(); i++) { //veszi az utolsó betűt a szórészlethez
      for (int j = 0; j <= input.length(); j++) { //az első betűt futtatja hozzá
        if (i - j >= 3) {
          partOfInput = input.substring(j, i);
          if (isPalindrome(partOfInput)) {
            polindroms.add(partOfInput);
          }
        }
      }
    }
    return polindroms;
  }

  public static boolean isPalindrome(String partOfAWord) {
    String reverseWord = "";
    for (int i = partOfAWord.length() - 1; i >= 0; i--) {
      reverseWord += partOfAWord.charAt(i);
    }
    return partOfAWord.equals(reverseWord);
  }
}
