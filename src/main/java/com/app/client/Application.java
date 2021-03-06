package com.app.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    log.info("main");

    UserClient userClient = new UserClient();
    userClient.greetUser();
  }
}
