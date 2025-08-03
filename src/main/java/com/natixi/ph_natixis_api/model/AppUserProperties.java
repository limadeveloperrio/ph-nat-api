package com.natixi.ph_natixis_api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app.security.user")
public record AppUserProperties(

        @NotBlank(message = "O nome do usuário não pode estar vazio")
        @Size(min = 3, max = 50, message = "O nome do usuário deve ter entre 3 e 50 caracteres")
        String name,

        @NotBlank(message = "A senha não pode estar vazia")
        @Size(min = 5, max = 100, message = "A senha deve ter entre 5 e 100 caracteres")
        String password
) {}
