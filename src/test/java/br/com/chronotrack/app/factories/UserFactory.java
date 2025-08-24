package br.com.chronotrack.app.factories;

import br.com.chronotrack.app.domain.dto.request.UserRequestDto;


public class UserFactory {

  public static UserRequestDto makeUserRequestDto(){
   return  new UserRequestDto("any_name", "any_email@mail.com",
     "any_password", "any_password");
  }
}
