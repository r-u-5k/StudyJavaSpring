package com.itwill.jpa.service;

import java.util.List;

import com.itwill.jpa.entity.Product;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductService {
    @Transactional
    Product getProduct(Long productId);

    Product saveProduct(Product product);

    Product updateProduct(Product product) throws Exception;

    void deleteProduct(Long number) throws Exception;

    List<Product> products();
}