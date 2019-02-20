package com.app.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

// This wrapper class allows generics to be used with RestTemplate.
// Otherwise, you must use the ParameterizedTypeReference hack.
public class UserList  {
  @JsonProperty
  private List<UserDto> users;

  public UserList() {
    users = new ArrayList<>();
  }

  public UserDto getUser(int index) {
    return users.get(index);
  }

  public void addUser(UserDto user) {
    users.add(user);
  }

  public int size() {
    return users.size();
  }
}