package com.instructure.talent.service;

import com.instructure.talent.user.UserDto;

public class UserService {
  UserDto userDto = new UserDto();

  public String getName() {
    return userDto.getName();
  }
}
