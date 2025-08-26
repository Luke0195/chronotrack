package br.com.chronotrack.app.domain.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

public record UserResponseDto(Long id, String name, String email, String password, Set<RoleResponseDto> roles, LocalDateTime createdAt, LocalDateTime updatedAt) {

}
