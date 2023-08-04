package com.nimap.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.model.Product;
import com.nimap.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) 
    {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product pro)
    
    {
        return productRepository.save(pro);
    }

    public Product updateProduct(Product pro) 
    {
        return productRepository.save(pro);
    }

    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id);
    }
    public List<Product> getAllProducts(int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        
        Page<Product> proPage = productRepository.findAll(pageable);
        
        
        return proPage.getContent();
    }

}

