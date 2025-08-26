package br.com.chronotrack.app.controller;

import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import br.com.chronotrack.app.domain.dto.response.UserResponseDto;
import br.com.chronotrack.app.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
   private final  UserServiceImpl userService;


  @PostMapping(value = "/signup")
  public ResponseEntity<?> handleAddUser(@RequestBody @Valid UserRequestDto userRequestDto){
    UserResponseDto userResponseDto = userService.add(userRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);


  }


}
