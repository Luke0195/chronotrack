package br.com.chronotrack.app.service.validators.user;

import br.com.chronotrack.app.repository.UserRepository;
import br.com.chronotrack.app.service.exceptions.ResourceAlreadyExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class UserValidatorTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserValidator userValidator;

  @DisplayName("validateIfUserExists should throws ResourceAlreadyExists if an existing email is provided")
  @Test
  void validateIfUserExistsShouldThrowsResourceAlreadyExistsIfAnExistingEmailIsProvided(){
    Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenThrow(ResourceAlreadyExistsException.class);
    Assertions.assertThrows(ResourceAlreadyExistsException.class, () -> {
      userValidator.validateIfUserExists("any_mail@mail.com");
    });
  }

}
