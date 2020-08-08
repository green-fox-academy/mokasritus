public class Palindrome {
  //Create a function named create palindrome following your current language's style guide.
  // It should take a string, create a palindrome from it and then return it.
  //
  //Examples
  //input	output
  //""	""
  //"greenfox"	"greenfoxxofneerg"
  //"123"	"123321"

  public static void main(String[] args) {
    System.out.println(createPalindrome("dog"));
  }

  public static String createPalindrome(String word) {
    String palindromeSecondPart = "";
    for (int i = word.length() - 1; i >= 0; i--) {
      palindromeSecondPart = palindromeSecondPart+ word.charAt(i);
    }
    String palindrome;
   return palindrome=word.concat(palindromeSecondPart);
  }
}
