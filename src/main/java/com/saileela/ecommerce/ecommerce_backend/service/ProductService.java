package com.saileela.ecommerce.ecommerce_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saileela.ecommerce.ecommerce_backend.model.Product;
import com.saileela.ecommerce.ecommerce_backend.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        return productRepository.save(existingProduct);
    }
    public String deleteProduct(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
        productRepository.deleteById(id);
        return "Product with ID " + id + " deleted successfully!";
    }
}
