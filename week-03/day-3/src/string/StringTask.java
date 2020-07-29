package string;

/*Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars
have been changed to 'y' chars.*/

public class StringTask {
  public static void main(String[] args) {
    String string = "nem szeretnék ebbe kis x-et tenni, csak nagy X-et";

    System.out.println(changeLowerXtoY(string));
  }

  public static String changeLowerXtoY(String string) {

    if (string.length() == 0) {
      return string;
    } else if (string.charAt(0) == 'x') {
      return 'y' + changeLowerXtoY(string.substring(1));
    } else {
      return string.charAt(0) + changeLowerXtoY(string.substring(1));
    }
  }
}
