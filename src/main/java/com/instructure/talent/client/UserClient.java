package com.instructure.talent.client;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.instructure.talent.service.UserService;
import com.instructure.talent.user.UserDto;

public class UserClient {
//  private UserService userService;

//  @Autowired
//  public void setUserService(UserService userService) {
//    this.userService = userService;
//  }

  public void getUserData() {
    System.out.println("inside getUserData");
//    UserService userService = new UserService();
//    userService.getUserData();

    RestTemplate restTemplate = new RestTemplate();
//    String user = "Allen";
    String user = restTemplate.getForObject("http://localhost:8080/MySpringApplication/user", String.class);
    System.out.println("Hello " + user);
  }
}
