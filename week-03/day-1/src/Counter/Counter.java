package Counter;

public class Counter {
  private int counter;
  private int initialValue;

  public Counter (int initialValue){
    this.counter = initialValue;
    this.initialValue = initialValue;
  }

  public Integer add (int number){
    return this.counter =this.counter +number;
  }
  public Integer add (){
    return ++counter;
  }

  public int get() {
    return counter;
  }

  public Integer reset(){
    return this.counter = this.initialValue;
  }
}
