package com.natixi.ph_natixis_api.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app.security.jwt")
public record JwtProperties(

        @NotBlank(message = "O header não pode estar vazio")
        String header,

        @NotBlank(message = "O prefix não pode estar vazio")
        String prefix,

        @NotBlank(message = "O secret não pode estar vazio")
        String secret
) {}
