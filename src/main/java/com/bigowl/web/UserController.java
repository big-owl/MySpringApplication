package com.bigowl.web;

import com.bigowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService = new UserService();

  @GetMapping("/")
  public String welcome() {
    String msg = "Welcome to MySpringApplication<br>"
        +"<br>"
        + "Get User Name - <a href=/application/get/name>/get/name</a><br>"
        + "Get User Name By Id - <a href=/application/get/999/name>/get/{id}/name</a><br>";
    return msg;
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
