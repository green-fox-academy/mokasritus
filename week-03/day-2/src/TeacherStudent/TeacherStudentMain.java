package TeacherStudent;

/*Create Student and Teacher classes
Student
learn() -> prints the student is learning something new
question(teacher) -> calls the teachers answer method
Teacher
teach(student) -> calls the students learn method
answer() -> prints the teacher is answering a question
Instantiate a Student and Teacher object
Call the student's question() method and the teacher's teach() method*/


public class TeacherStudentMain {
  public static void main(String[] args) {


  Student student1 = new Student();
  Teacher teacher1 = new Teacher();
   student1.question(teacher1);
   teacher1.teach(student1);

  }
}
