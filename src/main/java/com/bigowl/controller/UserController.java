package com.bigowl.controller;

import com.bigowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

  @Autowired
  UserService userService = new UserService();

  @GetMapping("/")
  public ModelAndView home() {
    return new ModelAndView("/index.jsp");
  }

  @GetMapping("/test")
  public ModelAndView test() {
    return new ModelAndView("/test.jsp");
  }

  @GetMapping("/get/name")
  public @ResponseBody ResponseEntity<String> get() {
    String name = userService.getName();
    return new ResponseEntity<String>(name, HttpStatus.OK);
  }

  @GetMapping("/get/{id}/name")
  public @ResponseBody ResponseEntity<String> getById(@PathVariable String id) {
    String name = userService.getName(id);
    return new ResponseEntity<String>(name, HttpStatus.OK);
  }

  @PutMapping("/put/{id}/{name}")
  public @ResponseBody ResponseEntity<String> post(@PathVariable String id, @PathVariable String name) {
    HttpStatus status = HttpStatus.NOT_MODIFIED;    // default
    if (userService.setName(id, name)) {
      status = HttpStatus.OK;
    }
    return new ResponseEntity<String>("PUT Response", status);
  }
}