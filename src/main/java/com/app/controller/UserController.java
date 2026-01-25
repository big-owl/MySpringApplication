package com.app.controller;

import com.app.service.UserService;

import com.app.user.UserDto;
import com.app.user.UserList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
      this.userService = userService;
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

  // Usage: Access as /user?id=1
  @GetMapping("/user")
  public ModelAndView user(@RequestParam(defaultValue = "0") long id) {
      UserDto user = userService.getUser(id);
    if (user == null) {
      user = new UserDto();  // Or handle with error page
    }
    ModelAndView modelAndView = new ModelAndView("userView");
    modelAndView.addObject("name", user.getName());
    modelAndView.addObject("id", user.getId());
    return modelAndView;
  }

  @GetMapping("/users")
  public @ResponseBody ResponseEntity<UserList> getUsers() {
    UserList users = userService.getAllUsers();
    return new ResponseEntity<UserList>(users, HttpStatus.OK);
  }

  @GetMapping("/user/{id}/name")
  public @ResponseBody ResponseEntity<String> getById(@PathVariable long id) {
    UserDto user = userService.getUser(id);
    if (user == null) {
      return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
    }
    String name = user.getName();
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
      userService.saveUser(user);  // Save to service instead of this.user
      modelAndView = new ModelAndView("userView");
      modelAndView.addObject("name", user.getName());
      modelAndView.addObject("id", user.getId());
    }
    return modelAndView;
  }

  @PutMapping("/user/{id}/{name}")
  public @ResponseBody ResponseEntity<String> updateName(@PathVariable long id, @PathVariable String name) {
    userService.updateUserName(id, name);
    HttpStatus status = HttpStatus.OK;
    return new ResponseEntity<String>("PUT Response", status);
  }

  // Usage: Access as /test?id=1
  @GetMapping("/test")
  public ModelAndView test(@RequestParam(defaultValue = "0") long id) {
    UserDto user = userService.getUser(id);
    if (user == null) {
      user = new UserDto();  // Or handle with error page
    }
    ModelAndView modelAndView = new ModelAndView("testEndpoints", "user", user);
    modelAndView.addObject("id", user.getId());
    return modelAndView;
  }
}
