package Cloneable;

public class Person {
  private String name;
  private int age;
  private String gender;

  public Person(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public Person(){
    name = "Jane Doe";
    age = 30;
    gender = "female";
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getGender() {
    return gender;
  }

  public void introduce(){
    System.out.println(
        "Hi, I'm " + name + ", a " + age + " year old " + gender + "."
    );
  }

  public void getGoal(){
    System.out.println("My goal is: Live for the moment!");
  }

  //Person osztály szülője az Object osztály, amely alapból tartalmazza a clone() methode-ot,
  //így a Studentbe (ennek a leszármazottjában) már csak override-oljuk.
}
