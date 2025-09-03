package br.com.chronotrack.app.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;


public record RoleRequestDto(
                             @NotEmpty(message = "The field name must be required")
                             String name
                             ) {
}
