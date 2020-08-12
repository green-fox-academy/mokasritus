package blog;

//g
//Reuse your BlogPost class
//Create a Blog class which can
//  store a list of BlogPosts
//  add BlogPosts to the list
//  delete(int) one item at given index
//  update(int, BlogPost) one item at the given index and update it with another BlogPost

import java.util.ArrayList;
import java.util.List;

public class Blog {
  List<BlogPost> posts = new ArrayList<>();

  public Blog() {
  }

  public void addPost(BlogPost post) {
    posts.add(post);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (BlogPost blogpost: posts
         ) {
      sb.append(blogpost).append("\n");
    }return sb.toString();
  }

  public void delete(int index){
    posts.remove(index);
  }

  public void upDate(int index, BlogPost post){
    posts.add(index,  post);
  }
}
