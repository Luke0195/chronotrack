package br.com.chronotrack.app.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record RoleRequestDto(
                             @NotEmpty(message = "The field name must be required")
                             String name
                             ) {
}
