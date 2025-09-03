package br.com.chronotrack.app.service.contracts.user;

import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import br.com.chronotrack.app.domain.dto.response.UserResponseDto;


public interface AddUserService {

  public UserResponseDto add(UserRequestDto userRequestDto);
}
