package dataStructure;

import java.util.HashMap;
import java.util.Map;

//We are going to represent our contacts in a map where the keys are going to be strings
// and the values are going to be strings as well.
//
//Create a map with the following key-value pairs.
//
//Name (key)	Phone number (value)
//William A. Lathan	405-709-1865
//John K. Miller	402-247-8568
//Hortensia E. Foster	606-481-6467
//Amanda D. Newland	319-243-5613
//Brooke P. Askew	307-687-2982
//Create an application which solves the following problems.
//
//What is John K. Miller's phone number?
//Whose phone number is 307-687-2982?
//Do we know Chris E. Myers' phone number?
public class TelephoneBook {
  public static void main(String[] args) {
    HashMap<String, String> telephoneBook = new HashMap<>();
    telephoneBook.put("William A. Latha", "405-709-1865");
    telephoneBook.put("John K. Miller", "402-247-8568");
    telephoneBook.put("Hortensia E. Foster", "606-481-6467");
    telephoneBook.put("Amanda D. Newland", "319-243-5613");
    telephoneBook.put("Brooke P. Askew", "307-687-2982");

    System.out.println(whatIsTheNumberOf(telephoneBook, "John K. Miller"));
    System.out.println(whoseNumberIs(telephoneBook, "307-687-2982"));
    System.out.println(doWeKnowTheNumberOf(telephoneBook, "Chris E. Myers"));
  }

  private static String doWeKnowTheNumberOf(HashMap<String, String> telephoneBook, String name) {
    if (telephoneBook.containsKey(name)) {
      return "yes";
    }
    return "no";
  }

  private static String whoseNumberIs(HashMap<String, String> telephoneBook, String phoneNumber) {
    String searchedName = null;
    for (Map.Entry<String, String> entry : telephoneBook.entrySet()) {
      if (entry.getValue().equals(phoneNumber)) {
        searchedName = ((entry.getKey()));
        break;
      }
    }
    return searchedName;
  }

  private static String whatIsTheNumberOf(HashMap<String, String> telephonBook, String name) {
    return telephonBook.get(name);
  }
}
