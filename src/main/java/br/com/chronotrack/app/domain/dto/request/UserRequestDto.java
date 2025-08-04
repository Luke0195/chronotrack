package br.com.chronotrack.app.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record UserRequestDto(
  @NotEmpty(message = "The field name must be required")
  String name,
  @NotEmpty(message = "The field email must be required")
  @Email(message = "Please provided a valid e-mail")
  String email,
  @NotEmpty(message = "The field password must be required")
  @Min(value = 8, message = "The field password must have least 8 characters")
  String password,
  @NotEmpty(message = "The field password_confirmation must be required")
  String passwordConfirmation
) {

  public boolean validatePassword(){
    return this.password.equalsIgnoreCase(this.passwordConfirmation);
  }
}
