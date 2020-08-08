package Cloneable;

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
    System.out.println("My goal is: Be a junior software developer");
  }

  @Override
  public void introduce() {
    System.out.println(
        "Hi, I'm " + getName() + ", a " + super.getAge() + " year old " + super.getGender() +
            " from " + this.previousOrganisation + " who skipped " + skippedDays + " days from the course already."
    );// super: constructor hívásnál, ha az ősosztályra hivatkozunk, vagy ha azonos nevű metódus van az ősön és a gyereken is és az őst akarom használni
  }

  public void skipDays(int numberOfDays){
    this.skippedDays += numberOfDays;
  }

  @Override
  public Student clone(){
    return new Student(getName(), getAge(), getGender(), previousOrganisation);
  }
}
