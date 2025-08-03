package br.com.chronotrack.app.controller;

import br.com.chronotrack.app.domain.dto.request.UserRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

  @PostMapping(value = "/signup")
  public ResponseEntity<?> handleAddUser(@RequestBody @Valid UserRequestDto userRequestDto){
    return null;
  }


}
