package com.instructure.talent.client;

import org.springframework.web.client.RestTemplate;

import com.instructure.talent.service.UserService;
import com.instructure.talent.user.UserDto;

public class UserClient {

  public void getUserData() {
    RestTemplate restTemplate = new RestTemplate();
    String user = restTemplate.getForObject("http://localhost:8080/application/user", String.class);
    System.out.println("Hello " + user);
  }
}
