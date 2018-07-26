package com.app.client;

import org.springframework.web.client.RestTemplate;

public class UserClient {

  public void greetUser() {
    RestTemplate restTemplate = new RestTemplate();
    String user = restTemplate.getForObject("http://localhost:8080/application/get/name", String.class);
    System.out.println("Hello " + user);
  }
}
