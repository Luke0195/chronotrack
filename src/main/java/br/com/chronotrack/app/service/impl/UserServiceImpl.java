package br.com.chronotrack.app.service.impl;

import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import br.com.chronotrack.app.domain.dto.response.UserResponseDto;
import br.com.chronotrack.app.domain.entities.User;
import br.com.chronotrack.app.repository.UserRepository;
import br.com.chronotrack.app.service.contracts.user.AddUserService;
import br.com.chronotrack.app.service.exceptions.PasswordsDoNotMatchException;
import br.com.chronotrack.app.service.exceptions.ResourceAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
public class UserServiceImpl implements AddUserService {

  private final UserRepository userRepository;


  @Override
  @Transactional
  public UserResponseDto add(UserRequestDto userRequestDto) {
    Optional<User> user = userRepository.findByEmail(userRequestDto.email());
    if(user.isPresent()) throw new ResourceAlreadyExistsException("This e-mail is already exists!");
    if(!userRequestDto.password().equalsIgnoreCase(userRequestDto.passwordConfirmation())) {
      throw new PasswordsDoNotMatchException("The field password_confirmation does not match with the field password");
    }

    return null;
  }
}
