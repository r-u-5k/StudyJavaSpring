package com.itwill.jpa.service;

import com.itwill.jpa.dto.ProductDto;
import com.itwill.jpa.entity.Product;
import com.itwill.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto getProduct(Long productId) {
        Product productEntity = productRepository.findById(productId).get();
        ProductDto productDto = ProductDto.toDto(productEntity);
        return productDto;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product productEntity = productRepository.save(Product.toEntity(productDto));
        return ProductDto.toDto(productEntity);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) throws Exception {
        Product productEntity = productRepository.save(Product.toEntity(productDto));
        return ProductDto.toDto(productEntity);
    }

    @Override
    public void deleteProduct(Long productId) throws Exception {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDto> productDtos() {
        List<Product> productEntityList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product productEntity : productEntityList) {
            productDtoList.add(ProductDto.toDto(productEntity));
        }
        return productDtoList;
    }
}
