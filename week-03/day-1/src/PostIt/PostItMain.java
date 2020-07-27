package PostIt;


public class PostItMain {
  public static void main(String[] args) {
  PostIt postIt1 = new PostIt("orange", "Idea 1", "blue");
    System.out.println(postIt1.getBackgroundColor());

  PostIt postIt2 = new PostIt("pink","Awesome", "black");
    System.out.println(postIt2.getText());

  PostIt postIt3 = new PostIt ("yellow", "Superb!", "green");
    System.out.println(postIt3.getTextColor());
  }
}
