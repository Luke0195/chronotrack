package br.com.chronotrack.app.factories;

import br.com.chronotrack.app.domain.dto.request.RoleRequestDto;
import br.com.chronotrack.app.domain.dto.request.UserRequestDto;


import java.util.HashSet;
import java.util.Set;


public class UserFactory {

  public static UserRequestDto makeUserRequestDto(){
    Set<RoleRequestDto> roles = new HashSet<>();
    roles.add(RoleFactory.makeRoleRequestDto());
   return  new UserRequestDto("any_name", "any_email@mail.com",
     "any_password", "any_password", roles);
  }
}
