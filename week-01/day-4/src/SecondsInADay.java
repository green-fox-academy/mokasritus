public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        // Write a program that prints the remaining seconds (as an integer) from a
        // day if the current time is represented by the variables

        int hours = 24;
        int minutesPerHours = 60;
        int secondsPerMinutes = 60;
        int remainingSeconds = hours * minutesPerHours * secondsPerMinutes -
                (currentHours * minutesPerHours * secondsPerMinutes + currentMinutes * secondsPerMinutes + currentSeconds);
        System.out.println(remainingSeconds);
    }
}
