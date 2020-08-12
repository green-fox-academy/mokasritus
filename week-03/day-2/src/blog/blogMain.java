package blog;

public class blogMain {
  public static void main(String[] args) {
    Blog blog = new Blog();

    BlogPost blogPost1 = new BlogPost("Béla", "Valami", "hát ez még nagyobb", "2020.20.20.");
    BlogPost blogPost2 = new BlogPost("Béla", "Valami2", "hát ez még nagyobb", "2020.20.20.");
    BlogPost blogPost3 = new BlogPost("Béla", "Valami3", "borzalom, kérem szépen"," 2020.20.20.");
    BlogPost blogPost4 = new BlogPost("Béla", "Valami4", "ez már jó lesz"," 2020.20.20.");
    blog.addPost(blogPost1);
    blog.addPost(blogPost2);
    blog.addPost(blogPost3);

    System.out.println(blog.toString());
    blog.delete(2);
    System.out.println(blog);
    blog.upDate(1, blogPost4);
    System.out.println(blog);
  }
}
