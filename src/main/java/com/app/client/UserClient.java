package com.app.client;

import com.app.user.UserDto;

import com.app.user.UserList;
import org.springframework.web.client.RestTemplate;

public class UserClient {

  public void greetUser() {
    RestTemplate restTemplate = new RestTemplate();
    UserList users;
    users = restTemplate.getForObject("http://localhost:8080/application/users", UserList.class);

    UserDto user = users.getUser(0);
    // TODO: replace this with a log info statement
    System.out.println("Hello " + user.getName());
  }
}
