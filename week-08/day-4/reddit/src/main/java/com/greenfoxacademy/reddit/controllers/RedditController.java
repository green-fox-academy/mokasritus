package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedditController {
  private PostService postService;

  @Autowired
  public RedditController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping(value = "/")
  public String renderMainPage(Model model) {
    model.addAttribute("posts", postService.findAllPosts());
    return "mainpage";
  }

  @GetMapping(value = "/submit")
  public String renderSubmitPage(Model model) {
    model.addAttribute("newPost", new Post());
    return "submit";
  }

  @PostMapping(value = "/submit")
  public String saveNewPost(Post newPost) {
    postService.saveNewPost(newPost);
    return "redirect:/";
  }

  @PostMapping(value = "/votingup")
  public String increaseVoteWithOne(@RequestParam int postId) {
    postService.increaseVoteWithOneById(postId);
    return "redirect:/";
  }

  @PostMapping(value = "/votingdown")
  public String decreaseVoteWithOne(@RequestParam int postId) {
    postService.decreaseVoteWithOneById(postId);
    return "redirect:/";
  }

}
