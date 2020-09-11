package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> findAllPosts() {
    return postRepository.findAll();
  }

  public void saveNewPost(Post newPost) {
  postRepository.save(newPost);
  }

  public void increaseVoteWithOneById(int postId) {
    Post foundById = getPostById(postId);
    foundById.setVote(foundById.getVote()+1);
    postRepository.save(foundById);
  }

  public void decreaseVoteWithOneById(int postId) {
    Post foundById = getPostById(postId);
    if(foundById.getVote()>0){
    foundById.setVote((foundById.getVote()-1));}
    else {
      foundById.setVote(0);
    }
    postRepository.save(foundById);
  }

  private Post getPostById(int postId) {
    return postRepository.findById(postId).orElseThrow(NoSuchElementException::new);
  }
}
