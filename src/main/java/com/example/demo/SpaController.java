package com.example.demo; // 你的包名可能不一样，保持原样即可

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


// Book.java
class Book {
  private String id;    // Matches TS: number | string
  private String title; // Matches TS: string
  private String author; // Matches TS: author? (can be null)

  // Constructor
  public Book(String id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  // Getters are required for Spring to convert to JSON
  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
}

@RestController // 1. 告诉Spring这是一个写API的类，不是写页面的
public class SpaController {

  @GetMapping("/api/data") // 2. 定义访问路径
  public Map<String, String> getData() {
    // 3. 直接返回对象，Spring会自动把它变成 JSON
    return Map.of("message", "Hello from Backend!", "status", "success");
  }

  @GetMapping("/api/data/book")
  public List<Book> getBooks() {
    List<Book> books = new ArrayList<>();

    // Example 1: ID is a number, Author is present
    books.add(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"));
    // Example 2: ID is a string, Author is null (matches 'author?')
    books.add(new Book("uuid-123", "Unknown Diary", null));

    // Spring automatically converts this List to a JSON Array
    return books;
  }

  @GetMapping("/api/data/geegee/hello") // 2. 定义访问路径
  public String geegeeHello() {
    // 3. 直接返回对象，Spring会自动把它变成 JSON
    return "hello world! geegee!!";
  }
}