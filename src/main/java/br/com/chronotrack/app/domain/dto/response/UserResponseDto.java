package br.com.chronotrack.app.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Set;

public record UserResponseDto(
  Long id,
  String name,
  String email,
  String password,
  Set<RoleResponseDto> roles,
  @JsonProperty("created_at")
  LocalDateTime createdAt,
  @JsonProperty("updated_at")
  LocalDateTime updatedAt) {

}
