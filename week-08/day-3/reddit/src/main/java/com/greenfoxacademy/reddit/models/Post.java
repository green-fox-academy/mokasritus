package com.greenfoxacademy.reddit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
  private String title;
  private String url;
  private Integer vote;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;
}
