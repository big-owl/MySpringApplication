package com.bigowl.user;

import java.io.Serializable;

public class UserDto implements Serializable {
  private long id = 999;    // default value

  private String name = "Allen";    // default value

  // returns the default user id
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  // returns the default user name
  public String getName() {
    return name;
  }

  // returns the user name if the provided id equals the current user id.
  public String getName(long id) {
    if (this.id == id) {
      return name;
    }
    else {
      return "unknown";
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  // Updates the default user name if the provided id equals the current user id.
  public boolean setName(long id, String name) {
    if (this.id == id) {
      this.name = name;
      return true;
    }
    else {
      return false;
    }
  }
}
