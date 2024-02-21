package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/addpro")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product),HttpStatus.CREATED);
    }
    
    
    @GetMapping("/getpro")
    public List<Product> getProduct() {
        return productService.getProduct();
    }
    
    @GetMapping("/getpro/{id}")
    public Optional<Product> getMethodName(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/editpro/{id}")
    public Product editProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.editProduct(id, product);
    }

    @DeleteMapping("/deletepro/{id}")
    public String deleteProduct(@PathVariable Long id)
    {
        return productService.deleteProduct(id);
    }
    

    
}
