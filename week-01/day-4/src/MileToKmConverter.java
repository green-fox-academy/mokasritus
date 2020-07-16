import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        // Write a program that asks for a double that is a distance in miles,
        // then it converts that value to kilometers and prints it

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me a distance in miles");
        int userInput2 = scanner.nextInt();

        System.out.println((double)userInput2*0.62137119223733 + " km");
    }
}
