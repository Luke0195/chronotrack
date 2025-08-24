package br.com.chronotrack.app.service.impl;

import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import br.com.chronotrack.app.domain.dto.response.UserResponseDto;
import br.com.chronotrack.app.domain.entities.User;
import br.com.chronotrack.app.repository.UserRepository;
import br.com.chronotrack.app.service.contracts.user.AddUserService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class UserServiceImpl implements AddUserService {

  private final UserRepository userRepository;


  @Override
  @Transactional
  public UserResponseDto add(UserRequestDto userRequestDto) {
    User user = userRepository.findByEmail(userRequestDto.email()).orElseThrow(() -> new RuntimeException("This email is already taken!"));
    return null;
  }
}
