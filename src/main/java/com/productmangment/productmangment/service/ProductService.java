
package com.productmangment.productmangment.service;

import com.productmangment.productmangment.entity.ProductEntity;
import com.productmangment.productmangment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository pr;

    // Get all products
    public List<ProductEntity> getAllProducts() {
        return pr.findAll();
    }

    // Create a product
    public ProductEntity createProduct(ProductEntity product) {
        return pr.save(product);
    }

    // Get product by ID
    public ProductEntity getProductById(Long id) {
        return pr.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Product not found with id: " + id));
    }

    // Delete product by ID
    public void deleteProduct(Long id) {
        if (!pr.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        pr.deleteById(id);
    }
}
