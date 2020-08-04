package greenfox;

public class Student extends Person {
  private String previousOrganisation;
  private int skippedDays;

  public Student(String name, int age, String gender, String previousOrganisation) {
    super(name, age, gender);
    this.previousOrganisation = previousOrganisation;
    this.skippedDays = 0;
  }

  public Student() {
    super();
    this.previousOrganisation = "The School of life";
    this.skippedDays = 0;
  }

  @Override
  public void getGoal() {
    System.out.println("Be a junior software developer");
  }

  @Override
  public void introduce() {
    System.out.println(
        "Hi, I'm " + super.getName() + ", a " + super.getAge() + " year old " + super.getGender() +
            " from " + this.previousOrganisation + " who skipped " + skippedDays + " days from the course already."
    );
  }

  public void skipDays(int numberOfDays){
    this.skippedDays += numberOfDays;
  }


}
