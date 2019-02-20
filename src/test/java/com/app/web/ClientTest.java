package com.app.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.app.user.UserDto;
import com.app.user.UserList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.client.RestTemplate;

public class ClientTest {
  private static final Logger log = LoggerFactory.getLogger(ClientTest.class);
  private static String url = "http://localhost:8080/application";
  RestTemplate restTemplate = new RestTemplate();
  private UserDto user;

  private void updateName(long id, String name) {
    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("name", name);
    // TODO: verify that the put was successful.  It will only succeed if the "id" is found (hasn't been modified).
    //  Need to fix this condition.
    restTemplate.put(url + "/user/{id}/{name}", null, params);
  }

  @BeforeEach
  void init() {
    UserList users;
    users = restTemplate.getForObject("http://localhost:8080/application/users", UserList.class);
    user = users.getUser(0);
  }

  @AfterEach
  void cleanup() {
    updateName(user.getId(), user.getName());
  }

  // Currently this test requires the application to be running on tomcat.
  // Otherwise a ResourceAccessException is thrown.
  // TODO: Use MockRestServiceServer for client-side REST (RestTemplate) testing.

  @Test
  // Test RESTful service PUT and GET endpoints.
  public void testPut() {
    log.info("testPut");

    long id = 999; //default
    String newName = "John";
    String returnedName;
    updateName(id, newName);  // users PUT

    returnedName = restTemplate.getForObject(url + "/user/" + id + "/name", String.class);
    assertEquals(newName, returnedName);
  }

  // TODO: write unit test for POST endpoint.
}
