package com.natixi.ph_natixis_api.service;

import com.natixi.ph_natixis_api.businessException.ResourceNotFoundException;
import com.natixi.ph_natixis_api.entity.Product;
import com.natixi.ph_natixis_api.interfaces.ProductService;
import com.natixi.ph_natixis_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado!"));
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product existing = findById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setDescription(product.getDescription());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}

