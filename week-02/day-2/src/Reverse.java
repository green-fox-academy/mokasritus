public class Reverse {
  public static void main(String... args) {
    String toBeReversed =
        ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

    System.out.print(reverse1(toBeReversed));
  }
  // Create a method that can reverse a String, which is passed as the parameter
  // Use it on this reversed string to check it!
  // Try to solve this using charAt() first, and optionally anything else after.

  //System.out.println(reverse(toBeReversed));

  //public static String reverse(String s) {
  //char[] temp = s.toCharArray();
  //String m = "";
  //for (int i = temp.length - 1; i >= 0; i--) {
  //  m = m.concat(String.valueOf(temp[i]));
  //}
  //return m;

  public static String reverse1(String s) {
    String m = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      m = m + s.charAt(i);
    }
    return m;
  }
}
