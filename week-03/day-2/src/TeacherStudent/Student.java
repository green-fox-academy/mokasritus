package TeacherStudent;

public class Student {

  public Student() {  }

  public void learn() {                             //mivel ezt példányon (student1) akarom használni ezért nem static, Staticot csak Class-on tudom meghívni (Student)
    System.out.println("Learning something new");
  }

  public void question(Teacher teacher){
     teacher.answer();
  }


}
