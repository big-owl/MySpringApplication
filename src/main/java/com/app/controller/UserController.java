package com.app.controller;

import com.app.user.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

  private UserDto user;

  @Autowired
  public UserController(UserDto user) {
    this.user = user;
  }

  // TODO: Field Injection is not recommended
  //@Autowired
  //UserDto user = new UserDto();

  @GetMapping("/")
  public ModelAndView home() {
    return new ModelAndView("index");
  }

  @GetMapping("/test")
  public ModelAndView test() {
    ModelAndView modelAndView = new ModelAndView("testEndpoints", "user", user);
    modelAndView.addObject("id", user.getId());
    return modelAndView;
  }

  @GetMapping("/user")
  public ModelAndView user() {
    ModelAndView modelAndView = new ModelAndView("userView");
    modelAndView.addObject("name", user.getName());
    modelAndView.addObject("id", user.getId());
    return modelAndView;
  }

  @PostMapping("/update")
  public ModelAndView submit(@ModelAttribute("user") UserDto user, BindingResult result) {
    ModelAndView modelAndView;
    if (result.hasErrors()) {
      modelAndView = new ModelAndView("testEndpoints", "user", user);
      modelAndView.addObject("id", user.getId());
      modelAndView.addObject("errorMessage", "invalid input");
    }
    else {
      this.user = user;
      modelAndView = new ModelAndView("userView");
      modelAndView.addObject("name", user.getName());
      modelAndView.addObject("id", user.getId());
    }
    return modelAndView;
  }

  @GetMapping("/get/name")
  public @ResponseBody ResponseEntity<String> get() {
    String name = user.getName();
    return new ResponseEntity<String>(name, HttpStatus.OK);
  }

  @GetMapping("/get/{id}/name")
  public @ResponseBody ResponseEntity<String> getById(@PathVariable long id) {
    String name = user.getName(id);
    return new ResponseEntity<String>(name, HttpStatus.OK);
  }

  @PutMapping("/put/{id}/{name}")
  public @ResponseBody ResponseEntity<String> post(@PathVariable long id, @PathVariable String name) {
    HttpStatus status = HttpStatus.NOT_MODIFIED;    // default
    if (user.setName(id, name)) {
      status = HttpStatus.OK;
    }
    return new ResponseEntity<String>("PUT Response", status);
  }
}
