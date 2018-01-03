package com.instructure.talent.web;

import com.instructure.talent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/")
  public String welcome() {
    return "Welcome to MySpringApplication";
  }

  @GetMapping("/user")
  public String user() {
    UserService userService = new UserService();
    return userService.getName();
  }
}
