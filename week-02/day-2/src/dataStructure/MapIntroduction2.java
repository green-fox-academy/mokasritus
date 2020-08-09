package dataStructure;

import java.util.HashMap;
import java.util.Map;

public class MapIntroduction2 {
  public static void main(String[] args) {
    //Create a map where the keys are strings and the values are strings with the following initial values
    //
    //Key	Value
    //978-1-60309-452-8	A Letter to Jo
    //978-1-60309-459-7	Lupus
    //978-1-60309-444-3	Red Panda and Moon Bear
    //978-1-60309-461-0	The Lab

    HashMap<String, String> m = new HashMap<>();
    m.put("978-1-60309-452-8", "A Letter to Jo");
    m.put("978-1-60309-459-7", "Lupus");
    m.put("978-1-60309-444-3", "Red Panda and Moon Bear");
    m.put("978-1-60309-461-0", "The Lab");

    //Print all the key-value pairs in the following format:
    // A Letter to Jo (ISBN: 978-1-60309-452-8)

    for (String key : m.keySet()) {
      System.out.println(m.get(key) + " (ISBN: " + key + ")");
    }

    //Remove the key-value pair with key 978-1-60309-444-3
    m.remove("978-1-60309-444-3", m.get("978-1-60309-444-3"));
    System.out.println(m);

    for (String papucs : m.keySet()) {
      System.out.println(m.get(papucs) + " (ISBN: " + papucs + ")");
    }

    //Remove the key-value pair with value The Lab
    for (Map.Entry<String, String> entry : m.entrySet()) {
      if (entry.getValue().equals("The Lab")) {
        m.remove(entry.getKey());
        break;
      }
    }
    System.out.println(m);

    //Add the following key-value pairs to the map
    //
    //Key	Value
    //978-1-60309-450-4	They Called Us Enemy
    //978-1-60309-453-5	Why Did We Trust Him?

    m.put("978-1-60309-450-4","They Called Us Enemy");
    m.put("978-1-60309-453-5","Why Did We Trust Him");

    //Print whether there is an associated value with key 478-0-61159-424-8 or not
    System.out.println(("478-0-61159-424-8"));

    //Print the value associated with key 978-1-60309-453-5
    System.out.println(m.get("978-1-60309-453-5"));
  }
}
