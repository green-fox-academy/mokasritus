public class CodingHours {
    public static void main(String[] args) {
        int dailyCodingHours = 6;
        int weeks = 17;
        int weekdays = 5;

        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.

        int semesterCodingHours = (dailyCodingHours * weekdays * weeks);
        System.out.println(semesterCodingHours);

        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52

        int weeklyWorkingHours = 52;
        int semesterWorkingHours = (weeklyWorkingHours * weeks);

        System.out.println(semesterCodingHours / (float)semesterWorkingHours * 100 +" %");
    }
}
