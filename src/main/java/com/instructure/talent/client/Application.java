package com.instructure.talent.client;

public class Application {

  public static void main(String[] args) {
    UserClient userClient = new UserClient();
    userClient.getUserName();
    userClient.setUserName("John");
    userClient.getUserName();
  }
}
