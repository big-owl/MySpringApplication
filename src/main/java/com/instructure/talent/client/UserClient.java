package com.instructure.talent.client;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class UserClient {
  RestTemplate restTemplate = new RestTemplate();
  long id = 999;    // default

  public void getUserName() {
    getUserName(id);
  }

  public void getUserName(long id) {
    String user = restTemplate.getForObject("http://localhost:8080/application/get/" + id + "/name", String.class);
    System.out.println("Hello " + user);
  }

  public void setUserName(String name) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("id", "999");
    params.put("name", name);
    restTemplate.put("http://localhost:8080/application/put/{id}/{name}", null, params);
  }
}
