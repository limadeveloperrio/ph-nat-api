package com.natixi.ph_natixis_api.controller;

import com.natixi.ph_natixis_api.entity.Product;
import com.natixi.ph_natixis_api.model.ProductRequest;
import com.natixi.ph_natixis_api.model.ProductResponse;
import com.natixi.ph_natixis_api.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping
    public List<ProductResponse> getAll() {
        return service.findAll()
                .stream()
                .map(p -> new ProductResponse(p.getId(), p.getName(), p.getPrice(), p.getDescription()))
                .toList();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        var p = service.findById(id);
        return new ProductResponse(p.getId(), p.getName(), p.getPrice(), p.getDescription());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        var saved = service.save(new Product(null, request.name(), request.price(), request.description()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProductResponse(saved.getId(), saved.getName(), saved.getPrice(), saved.getDescription()));
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        var updated = service.update(id, new Product(id, request.name(), request.price(), request.description()));
        return new ProductResponse(updated.getId(), updated.getName(), updated.getPrice(), updated.getDescription());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
