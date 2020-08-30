package exercises.Exercise10;

//Create a Fox class with 3 properties:name, color and age Fill a list with at least 5 foxes and:
//
//Write a Stream Expression to find the foxes with green color!
//Write a Stream Expression to find the foxes with green color, and age less then 5 years!
//Write a Stream Expression to find the frequency of foxes by color!

public class Fox {
 protected String name;
 protected String color;
 protected int age;

 public Fox (String name, String color, int age){
   this.name=name;
   this.color=color;
   this.age=age;
 }

 @Override
  public String toString(){
   return name;
 }
}
