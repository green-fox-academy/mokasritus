package com.greenfoxacademy.library.models;

public class Book {
  private int id;
  private String title;
  private String author;
  private Integer releaseYear;

  private static int nextId = 0;

  public Book(String title, String author, Integer releaseYear) {
    this.title = title;
    this.author = author;
    this.releaseYear = releaseYear;
    this.id = nextId++;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public static int getNextId() {
    return nextId;
  }

  public static void setNextId(int nextId) {
    Book.nextId = nextId;
  }
}
