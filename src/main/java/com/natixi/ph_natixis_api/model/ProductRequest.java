package com.natixi.ph_natixis_api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String name,

        @NotNull(message = "O preço é obrigatório")
        @Min(value = 1, message = "O preço deve ser maior que zero")
        BigDecimal price,

        @Size(max = 255, message = "A descrição pode ter no máximo 255 caracteres")
        String description
) {
}


