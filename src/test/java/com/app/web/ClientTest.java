package com.app.web;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.client.RestTemplate;

public class ClientTest {
  private static final Logger log = LoggerFactory.getLogger(ClientTest.class);

  @Test
  // Test RESTful service PUT and GET endpoints.
  public void testPut() {
    log.info("testPut");

    RestTemplate restTemplate = new RestTemplate();
    String id = "999";    // default
    String returnedName;
    String expectedName = "Allen";  // default
    String newName = "John";
    Map<String, String> params = new HashMap<>();
    params.put("id", id);
    params.put("name", newName);

    restTemplate.put("http://localhost:8080/application/put/{id}/{name}", null, params);
    expectedName = newName;
    returnedName = restTemplate.getForObject("http://localhost:8080/application/get/" + id + "/name", String.class);
    assertEquals(returnedName, expectedName);
  }

  // TODO: write unit test for POST endpoint.
}
