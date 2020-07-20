import java.util.Arrays;

public class ReverseList {
  public static void main(String[] args) {
    // - Create an array variable named `numbers`
    //   with the following content: `[3, 4, 5, 6, 7]`
    // - Reverse the order of the elements in `numbers`
    // - Print the elements of the reversed `numbers`

    int[] numbers = {3, 4, 5, 6, 7};

    int[] temp = new int[numbers.length];
    for (int i = numbers.length - 1; i > -1; i--) {
      temp[numbers.length - i - 1] = numbers[i];
    }
    numbers = temp;
    System.out.println(Arrays.toString(numbers));
  }
}
