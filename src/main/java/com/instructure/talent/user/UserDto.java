package com.instructure.talent.user;

import java.io.Serializable;

public class UserDto implements Serializable {
  private long id = 999;

  private String name = "Allen";

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
