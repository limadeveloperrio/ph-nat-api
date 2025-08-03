package com.natixi.ph_natixis_api.repository;

import com.natixi.ph_natixis_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}

