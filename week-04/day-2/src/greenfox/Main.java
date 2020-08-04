package greenfox;

public class Main {
  public static void main(String[] args) {
    Person person = new Person ();
    person.getGoal();
    person.introduce();

    Person person1 = new Person("Boldizsar", 25, "male");
    person1.introduce();

    Student student = new Student();
    student.introduce();

    student.skipDays(3);
    student.introduce();
    student.skipDays(5);
    student.introduce();

    Mentor mentor = new Mentor();
    mentor.getGoal();
    mentor.introduce();

  }
}
