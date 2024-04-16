package com.itwill.jpa.relation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

class ProductDetailRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProductDetailRepository productDetailRepository;

	@Transactional
	@Rollback(false)
	@Test
	void productDetailWithProductSaveRead() {
		Product product = Product.builder().name("JPA").price(20000).stock(50).build();
		ProductDetail productDetail = ProductDetail.builder().description("JPA 책 설명").build();

		/*
		 연관관계 설정 (OWNER)
		 ProductDetail --> Product
		*/
		productDetail.setProduct(product);
		productDetailRepository.save(productDetail);

		System.out.println("--------read-----------");
		ProductDetail findProductDetail = productDetailRepository.findById(1L).get();
		System.out.println(findProductDetail);
		Product findProduct = findProductDetail.getProduct();
		System.out.println(findProduct);

	}

	@Test
	@Transactional
	void productDetailWithProductRead() {
		ProductDetail findProductDetail = productDetailRepository.findById(1L).get();
		System.out.println("findProductDetail: " + findProductDetail);
		Product findProduct = findProductDetail.getProduct();
		System.out.println("findProduct: " + findProduct);
	}

}
