package com.itwill.jpa.relation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Transactional
	@Rollback(false)
	@Test
	void productWithCategorySaveAndRead() {
		Category category1 = Category.builder().code("IT").name("프로그래밍").build();
		
		Product product1 = Product.builder().name("Spring").price(30000).stock(100).build();
		Product product2 = Product.builder().name("JAVA").price(32000).stock(200).build();
		Product product3 = Product.builder().name("JavaScript").price(28000).stock(150).build();

		/*
		 * 연관관계설정 Product-->Category
		 */
		product1.setCategory(category1);
		product2.setCategory(category1);
		product3.setCategory(category1);

		/*
		엔티티를 저장하고 변경 사항을 데이터베이스에 즉시 동기화합니다.
		- saveAndFlush
		 */
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		Product findProduct = productRepository.findById(1L).get();
		System.out.println(findProduct);
		System.out.println(findProduct.getCategory());

	}

	void productWithProviderSaveAndRead() {

		/***** 연관설정 Product-->Provider *****/
		System.out.println("--------------read-------------");

	}

	void productWithProductDetailSaveAndRead() {

		/*
		 * 연관관계설정(OWNER테이블아닌경우)
		 * Product-->ProductDetail
		 */
	}

}