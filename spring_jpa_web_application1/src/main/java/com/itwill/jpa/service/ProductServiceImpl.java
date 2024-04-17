package com.itwill.jpa.service;

import com.itwill.jpa.entity.Product;
import com.itwill.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws Exception {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Product deleteProduct = productRepository.findById(number).get();
        productRepository.delete(deleteProduct);
    }

    @Override
    public List<Product> products() {
        return productRepository.findAll();
    }
}
