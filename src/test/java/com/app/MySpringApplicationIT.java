package com.app;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MySpringApplicationIT {

  @Autowired
  private WebApplicationContext webAppContext;

  @Test
  public void contextLoads() {
    assertNotNull(webAppContext);
  }

}


