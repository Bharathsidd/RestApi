package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product)
    {
        return productRepo.save(product);
    }

    public List<Product> getProduct()
    {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id)
    {
        return productRepo.findById(id);
    }

    public Product editProduct(Long id,Product product)
    {
        Product productAvail=productRepo.findById(id).orElse(null);
        if(productAvail!=null)
        {
             productAvail.setProductName(product.getProductName());
             productAvail.setPrice(product.getPrice());
             productAvail.setDescription(product.getDescription());
             productAvail.setQuantity(product.getQuantity());
             return productRepo.saveAndFlush(product);
        }
        else 
        {
            return null;
        }
    }

    public String deleteProduct(Long id)
    {
        productRepo.deleteById(id);
        return ("Product deleted");
    }
}
