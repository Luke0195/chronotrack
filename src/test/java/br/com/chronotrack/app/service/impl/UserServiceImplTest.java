package br.com.chronotrack.app.service.impl;

import br.com.chronotrack.app.domain.dto.request.RoleRequestDto;
import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import br.com.chronotrack.app.factories.RoleFactory;
import br.com.chronotrack.app.factories.UserFactory;
import br.com.chronotrack.app.repository.RoleRepository;
import br.com.chronotrack.app.repository.UserRepository;
import br.com.chronotrack.app.service.exceptions.PasswordsDoNotMatchException;
import br.com.chronotrack.app.service.exceptions.ResourceAlreadyExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;
  @Mock
  private RoleRepository roleRepository;
  private UserRequestDto userRequestDto;
  @InjectMocks
  private UserServiceImpl userService;

  @DisplayName("Add should returns UnprocessedEntity if an email already exists")
  @Test
  void addShouldReturnsResourceAlreadyExistsWhenAnValidEmailAlreadyExists(){
    Mockito.when(userRepository.findByEmail(Mockito.any())).thenThrow(ResourceAlreadyExistsException.class);
    final UserRequestDto userRequestDto = UserFactory.makeUserRequestDto();
    Assertions.assertThrows(ResourceAlreadyExistsException.class, () -> {
        userService.add(userRequestDto);
    });
  }

  @DisplayName("Add should throws PasswordDoesNotMatchException if password does not match with password confirmation")
  @Test
  void addShouldReturnsPasswordDoesNotMatchExceptionWhenPasswordDoesNotMatchWithPasswordConfirmation(){
    final UserRequestDto userRequestDto  = new UserRequestDto("any_name", "any_mail@mail.com",
      "any_password", "12345", new HashSet<>());
    Assertions.assertThrows(PasswordsDoNotMatchException.class, () -> {
        userService.add(userRequestDto);
    });
  }

  @DisplayName("Add should throws ResourceNotFoundException when an invalid role is provided")
  @Test
  void addShouldReturnsResourceNotFoundExceptionWhenAnInvalidRoleIsProvided(){;
    final UserRequestDto userRequestDto = UserFactory.makeUserRequestDto();
    Mockito.when(roleRepository.findByName(Mockito.any())).thenThrow(ResourceAlreadyExistsException.class);
    Assertions.assertThrows(ResourceAlreadyExistsException.class, () -> {
      userService.add(userRequestDto);
    });
  }

}
