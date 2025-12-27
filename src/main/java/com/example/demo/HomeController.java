package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
  @GetMapping("/")
  public String home() {
    return "现在访问首页不是 index2.html 了，而是我这段文字！";
  }

  @GetMapping("/index2.html")
  public String index2Page() {
    return "现在访问首页不是 index2.html 了，而是我这段文字！";
  }
}
