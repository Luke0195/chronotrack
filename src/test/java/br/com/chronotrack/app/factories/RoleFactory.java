package br.com.chronotrack.app.factories;

import br.com.chronotrack.app.domain.dto.request.RoleRequestDto;
import br.com.chronotrack.app.domain.dto.response.RoleResponseDto;
import br.com.chronotrack.app.domain.entities.Role;

import java.time.LocalDateTime;

public class RoleFactory {

  public static RoleRequestDto makeRoleRequestDto(){
    return new RoleRequestDto("any_name");
  }

  public static Role makeRole(RoleRequestDto roleRequestDto){
    return new Role(1L, roleRequestDto.name(), LocalDateTime.now(), null);
  }

  public static RoleResponseDto makeRoleResponseDto(Role role){
    return new RoleResponseDto(role.getId(), role.getName(), role.getCreatedAt(), role.getUpdatedAt());
  }
}
