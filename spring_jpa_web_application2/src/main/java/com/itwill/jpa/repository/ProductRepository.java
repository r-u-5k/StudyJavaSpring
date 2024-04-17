package com.itwill.jpa.repository;



import com.itwill.jpa.dto.ProductDto;
import com.itwill.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
