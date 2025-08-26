package com.nexura.agendaSegurosBackend.Config.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @Email @NotBlank  String email,
        @NotBlank @Min(8) String contrasenia
) {
}
