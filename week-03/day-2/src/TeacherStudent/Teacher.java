package TeacherStudent;

public class Teacher {

  public Teacher() { }

  public void answer() {
    System.out.println("Answering a question");
  }

  public void teach(Student student) {
    student.learn();
  }
}
