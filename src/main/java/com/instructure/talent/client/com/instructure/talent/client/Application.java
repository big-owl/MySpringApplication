package com.instructure.talent.client;

import com.instructure.talent.client.UserClient;

public class Application {

  public static void main(String[] args) {
    UserClient userClient = new UserClient();
    userClient.getUserData();
  }
}
