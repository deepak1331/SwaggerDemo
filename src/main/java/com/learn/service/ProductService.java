package com.learn.service;

import com.learn.entity.Product;
import com.learn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        Product product = productRepository.findByName(name);
        return product;
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product Deleted Successfully";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
}
