package br.com.chronotrack.app.service.validators.user;
import br.com.chronotrack.app.domain.entities.User;
import br.com.chronotrack.app.repository.UserRepository;
import br.com.chronotrack.app.service.exceptions.ResourceAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserValidator {

  private final  UserRepository userRepository;

  public void validateIfUserExists(String email) {
     if(userRepository.findByEmail(email).isPresent()) throw new ResourceAlreadyExistsException("This email is already exists!");
  }
  public boolean checkPassword(User user, String password) {
   return user.isValidPassword(password);
  }

}
