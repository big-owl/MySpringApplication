package com.app.controller;

import com.app.user.UserDto;
import com.app.user.UserList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

  private UserDto user;

  @Autowired
  public UserController() {
    this.user = new UserDto();
  }

  @Autowired
  @Qualifier("userFormValidator")
  private Validator validator;

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(validator);
  }

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

  @GetMapping("/users")
  public @ResponseBody ResponseEntity<UserList> getUsers() {
    UserList users = new UserList();
    users.addUser(user);
    return new ResponseEntity<UserList>(users, HttpStatus.OK);
  }

  @GetMapping("/user/{id}/name")
  public @ResponseBody ResponseEntity<String> getById(@PathVariable long id) {
    String name = user.getName(id);
    return new ResponseEntity<String>(name, HttpStatus.OK);
  }

  @PostMapping("/user/update")
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

  @PutMapping("/user/{id}/{name}")
  public @ResponseBody ResponseEntity<String> updateName(@PathVariable long id, @PathVariable String name) {
    HttpStatus status = HttpStatus.NOT_MODIFIED;    // default
    if (user.setName(id, name)) {
      status = HttpStatus.OK;
    }
    return new ResponseEntity<String>("PUT Response", status);
  }
}
