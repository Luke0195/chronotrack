package br.com.chronotrack.app.service.impl;

import br.com.chronotrack.app.domain.dto.request.RoleRequestDto;
import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import br.com.chronotrack.app.domain.dto.response.RoleResponseDto;
import br.com.chronotrack.app.domain.dto.response.UserResponseDto;
import br.com.chronotrack.app.domain.entities.Role;
import br.com.chronotrack.app.domain.entities.User;
import br.com.chronotrack.app.repository.RoleRepository;
import br.com.chronotrack.app.repository.UserRepository;
import br.com.chronotrack.app.service.contracts.user.AddUserService;
import br.com.chronotrack.app.service.exceptions.PasswordsDoNotMatchException;
import br.com.chronotrack.app.service.exceptions.ResourceAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements AddUserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;


  @Override
  @Transactional
  public UserResponseDto add(UserRequestDto userRequestDto) {
    Set<Role> roles = new HashSet<>();
    Optional<User> user = userRepository.findByEmail(userRequestDto.email());
    if(user.isPresent()) throw new ResourceAlreadyExistsException("This e-mail is already exists!");
    if(!userRequestDto.password().equalsIgnoreCase(userRequestDto.passwordConfirmation())) {
      throw new PasswordsDoNotMatchException("The field password_confirmation does not match with the field password");
    }
    for(RoleRequestDto roleRequestDto:userRequestDto.roles()){
      Role role = roleRepository.findByName(roleRequestDto.name()).orElseThrow(() -> new ResourceAlreadyExistsException("This role was not found"));
      roles.add(new Role(role.getId(), role.getName(), role.getCreatedAt(), role.getUpdatedAt()));
    }
    User createdUser = userRepository.save(User.builder().name(userRequestDto.name()).email(userRequestDto.email()).password(userRequestDto.password()).build());
    return new UserResponseDto(createdUser.getId(), createdUser.getName(), createdUser.getEmail(), createdUser.getPassword(),
      roles.stream().map((element) -> new RoleResponseDto(element.getId(), element.getName(), element.getCreatedAt(), element.getUpdatedAt()))
        .collect(Collectors.toSet()), createdUser.getCreatedAt(), createdUser.getUpdatedAt());
  }
}
