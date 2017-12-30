package com.instructure.talent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/MySpringApplication")
public class UserController {

  @RequestMapping("/")
  public String welcome() {
    System.out.println("inside welcome");
    return "Welcome to MySpringApplication";
  }

//  @RequestMapping(method = RequestMethod.GET)
  @GetMapping("/user")
  public String user() {
    System.out.println("inside user");
    return "Allen";
  }
}
