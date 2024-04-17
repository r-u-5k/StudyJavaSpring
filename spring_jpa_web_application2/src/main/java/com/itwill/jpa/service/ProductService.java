package com.itwill.jpa.service;

import java.util.List;

import com.itwill.jpa.dto.ProductDto;
import com.itwill.jpa.entity.Product;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductService {
    @Transactional
    ProductDto getProduct(Long productId);

    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto) throws Exception;

    void deleteProduct(Long productId) throws Exception;

    List<ProductDto> productDtos();
}