package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.user.UserDto;

@Component("userFormValidator")
public class UserFormValidator implements Validator {

  //which objects can be validated by this validator
  @Override
  public boolean supports(Class<?> paramClass) {
    return UserDto.class.equals(paramClass);
  }

  // This method is where any custom validation logic should go
  @Override
  public void validate(Object obj, Errors errors) {

    UserDto userDto = (UserDto) obj;
    // if validation fails then -
    // errors.rejectValue(<field>, <errorCode>);
  }
}
