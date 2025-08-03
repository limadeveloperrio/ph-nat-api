package com.natixi.ph_natixis_api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(

        @NotBlank(message = "O usuário é obrigatório")
        @Size(min = 3, max = 50, message = "O usuário deve ter entre 3 e 50 caracteres")
        String username,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 5, max = 100, message = "A senha deve ter entre 5 e 100 caracteres")
        String password
) {}


