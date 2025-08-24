package br.com.chronotrack.app.service.impl;

import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import br.com.chronotrack.app.domain.entities.User;
import br.com.chronotrack.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  private UserRequestDto userRequestDto;
  @InjectMocks
  private UserServiceImpl userService;

  @DisplayName("Add should returns UnprocessedEntity if an email already exists")
  @Test
  void addShouldReturnsUnprocessedEntityIfEmailAlreadyExists(){
    Mockito.when(userRepository.findByEmail(Mockito.any())).thenThrow(RuntimeException.class);
    final UserRequestDto userRequestDto = new UserRequestDto("any_name", "any_mail@mail.com", "any_password", "any_password");
    Assertions.assertThrows(RuntimeException.class, () -> {
        userService.add(userRequestDto);
    });
  }

}
