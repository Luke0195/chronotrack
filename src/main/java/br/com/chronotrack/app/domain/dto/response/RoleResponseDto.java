package br.com.chronotrack.app.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record RoleResponseDto(
  Long id,
  String name,
  @JsonProperty("created_at")
  LocalDateTime createdAt,
  @JsonProperty("updated_at")
  LocalDateTime updatedAt) {
}
