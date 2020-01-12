package com.uga.edu.model;

import java.io.Serializable;

public class Author implements Serializable {

  private String first_author;
  private String second_author;

  public Author() {}

  public Author(String first_author, String second_author) {
    super();
    this.first_author = first_author;
    this.second_author = second_author;
  }


  public String getFirst_author() {
    return first_author;
  }

  public void setFirst_author(String first_author) {
    this.first_author = first_author;
  }

  public String getSecond_author() {
    return second_author;
  }

  public void setSecond_author(String second_author) {
    this.second_author = second_author;
  }

  @Override
  public String toString() {
    return "Author{" +
      "first_author='" + first_author + '\'' +
      ", second_author='" + second_author + '\'' +
      '}';
  }
}
