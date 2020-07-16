public class Swap {
    public static void main(String[] args) {
        // Swap the values of the variables
        int a = 123;
        int b = 526;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int temporary = a;
        a = b;
        b = temporary;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
