package com.greenfoxacademy.webapplication.utilities;// # Useful Utilities

// Create a controller with 4 endpoints where the user can use the useful utilities.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {

  private List<String> colors;
  private Random random;

  public UtilityService() {
    colors = new ArrayList<>();
    colors.add("red");
    colors.add("blue");
    colors.add("lime");
    colors.add("orange");
    colors.add("magenta");
    random = new Random();
  }

  public String randomColor() {
    return colors.get(random.nextInt(colors.size()));
  }

  // - Create a `validateEmail()` method in the `UtilityService`
//     - check if the string contains a `@` and a `.`

  public String validateEmail(String email){
    if (email.contains("@")&&email.contains(".")){
      return "green";
    } else {
      return "red";
    }
  }


  public String caesar(String text, int number) {
    if (number < 0) {
      number = 26 + number;
    }

    String result = "";
    for (int i = 0; i < text.length(); i++) {
      int offset = Character.isUpperCase(text.charAt(i)) ? 'A' : 'a';
      result += (char) (((int) text.charAt(i) + number - offset) % 26 + offset);
    }
    return result;
  }
}
