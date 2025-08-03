package com.natixi.ph_natixis_api.interfaces;

import com.natixi.ph_natixis_api.entity.Product;
import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    Product update(Long id, Product product);

    void delete(Long id);
}

