package blog;

public class BlogPost {
  private String authorName;
  private String title;
  private String text;
  private String publicationDate;

  public BlogPost (String authorName, String title, String text, String publicationDate) {
    this.authorName = authorName;
    this.title = title;
    this.text = text;
    this.publicationDate = publicationDate;
  }

  public String getText() {
    return text;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthorName() {
    return authorName;
  }

  public String getPublicationDate() {
    return publicationDate;
  }

  @Override
  public String toString() {
    return "\"" + this.title + "\" titled by " + this.authorName + " posted at " +
        this.publicationDate + "\n\t" + this.text;
  }
}