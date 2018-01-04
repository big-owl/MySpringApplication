package com.instructure.talent.service;

import com.instructure.talent.user.UserDto;

public class UserService {
  UserDto userDto = new UserDto();

  public String getName() {
    return userDto.getName();
  }

  public String getName(String sid) {
    try {
      long id = Long.parseLong(sid);
      return userDto.getName(id);
    }
    catch (NumberFormatException ex) {
      return "unknown";
    }
  }

  public boolean setName(String sid, String name) {
    try {
      long id = Long.parseLong(sid);
      return userDto.setName(id, name);
    }
    catch (NumberFormatException ex) {
      return false;
    }
  }
}
