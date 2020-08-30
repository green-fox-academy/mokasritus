package com.greenfoxacademy.library.controllers;

import com.greenfoxacademy.library.models.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

  private List<Book> books = new ArrayList<>();

  public BookController() {
    books.add(new Book("Cat's Cradle", "Kurt Vonnegut", 1963));
    books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968));
  }

 /*  @RequestMapping(path = "/books", method = RequestMethod.GET)
  //@GetMapping ("/books")
 public String showBooks(Model model) {
    model.addAttribute("books", books);
    return "index";
  }*/

  //Details of a book by an id
  @RequestMapping(path = "/books/{id}/details", method = RequestMethod.GET)
  public String getBookById(Model model, @PathVariable(name = "id") Integer id) {
    Book bookById = null;

    for (Book book : books) {
      if (book.getId() == id) {
        bookById = book;
      }
    }

    if (bookById != null) {
      model.addAttribute("book", bookById);
    } else {
      model.addAttribute("error", "No book found");
    }

    return "details";
  }

  //List books by author
  @RequestMapping(path = "/books", method = RequestMethod.GET)
  public String showBooks(Model model,
                          @RequestParam(name = "author", required = false) String author) {

    List<Book> queriedBooks;

    if (author != null) {
      queriedBooks = filterBooksByAuthor(author);
    } else {
      queriedBooks = books;
    }

    model.addAttribute("books", queriedBooks);
    return "index";
  }

  //Add a new book
  //endpoint where we can request the form where we can add new books.
  @RequestMapping(path = "/books/add", method = RequestMethod.GET)
  public String addBookForm(Model model, @ModelAttribute(name = "book") Book book) {
    model.addAttribute("book", book);
    return "create";
  }

  // endpoint which will be able to process the data once the form
  // is sent back to the backend. It should save the book
  // to the books list then redirect the user to the book listing page.
  @RequestMapping(path = "/books/add", method = RequestMethod.POST)
  public String addBook(@ModelAttribute(name = "book") Book book) {
    books.add(book);
    return "redirect:/books";
  }

  private List<Book> filterBooksByAuthor(String author) {
    return books.stream()
        .filter(book -> book.getAuthor().equals(author))
        .collect(Collectors.toList());
  }
}