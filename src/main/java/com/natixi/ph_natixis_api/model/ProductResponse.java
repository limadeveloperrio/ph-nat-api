package com.natixi.ph_natixis_api.model;

import java.math.BigDecimal;

public record ProductResponse(Long id, String name, BigDecimal price, String description) {
}
