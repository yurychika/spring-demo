package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 注意：这里必须用 @Controller，不能用 @RestController
public class SpaRedirectController {

  // 正则表达式解释：匹配所有不包含 "." 的路径 (排除 .js, .css, .png 等静态文件)
  // Spring 的机制是：如果有精确匹配的 API (如 /api/data)，会优先走 API，不会进这里
  @RequestMapping(value = "/{path:[^\\.]*}")
  public String redirect() {
    // forward: 表示服务器内部转发。
    // 浏览器的 URL 不会变，但用户实际看到的是 index2.html 的内容
    return "forward:/index2.html";
  }

  @RequestMapping(value = "/blabla")
  public String redirectBlabla() {
    // forward: 表示服务器内部转发。
    // 浏览器的 URL 不会变，但用户实际看到的是 index2.html 的内容
    return "redirect:/blabla.html";
  }
}