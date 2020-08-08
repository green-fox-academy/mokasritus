package hardones;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.Arrays;
import org.w3c.dom.ls.LSOutput;

public class Unique {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as a parameter
    //  Returns a list of numbers where every number in the list occurs only once

    //  Example
    System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
    //  should print: `[1, 11, 34, 52, 61]`
  }

  public static String unique(int[] numbers) {
    int[] everyNumberOnlyOnes = new int[numbers.length];
    int i = 0;
    for (int number : numbers) {
      if (!Arrays.toString(everyNumberOnlyOnes).contains(Integer.toString(number))) {
        everyNumberOnlyOnes[i] = number;
        i++;
      }
    }
    return Arrays.toString(Arrays.copyOf(everyNumberOnlyOnes, i));
  }
}