package com.app.user;

import java.io.Serializable;

public class UserDto implements Serializable {
  private long id = 0; // default value

  private String name = "unknown";  // default value

  // returns the user id
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  // returns the user name
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return "id = " + id + "\n" + "name = " + name;
  }
}
