package com.greenfoxacademy.reddit.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "posts")
public class Post {
  private String title;
  private String url;
  private Integer vote;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;

  @Temporal(TemporalType.DATE)
  private Date date;

  public Post() {
    vote = 0;
    this.date = new Date();
  }

  public String getTitle() {
    return title;
  }

  public Date getDate() {
    return date;
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
