package com.greenfoxacademy.reddit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
  private String title;
  private String url;
  private Integer vote;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;

  public Post() {
    vote = 0;
  }

  public String getTitle() {
    return title;
  }

  public Integer getVote() {
    return vote;
  }

  public String getUrl() {
    return url;
  }

  public int getId() {
    return Id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setVote(Integer vote) {
    this.vote = vote;
  }

}
