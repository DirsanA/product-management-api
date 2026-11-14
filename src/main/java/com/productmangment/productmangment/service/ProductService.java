
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
    //Update product by ID
    public ProductEntity updateProduct(Long id,ProductEntity updatedProduct){
        // Step 1: Find the existing product
        ProductEntity existingProduct = pr.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Product not found with id: " + id));

        // Step 2: Update product fields
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());

        // Step 3: Save the updated product
        return pr.save(existingProduct);


    }
}
