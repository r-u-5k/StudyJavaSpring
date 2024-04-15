package com.itwill.jpa.relation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;

class CategoryRepositoryTest extends SpringJpaRelationApplicationTests{
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	@Transactional
	@Rollback(value = false)
	void categoryWithProductsSaveAndReadDelete() {
		/***************[CascadeType.PERSIST]**************/
		Category category1 = Category.builder().code("IT").name("프로그래밍").build();
		Category category2 = Category.builder().code("Hobby").name("취미").build();
		
		Product product1 = Product.builder().name("Spring").price(30000).stock(100).build();
		Product product2 = Product.builder().name("JAVA").price(32000).stock(200).build();
		Product product3 = Product.builder().name("JavaScript").price(28000).stock(150).build();
		
		/*
		 * 연관관계 설정
		 * Category --> Product
		 */
		category1.getProducts().add(product1);
		category1.getProducts().add(product2);
		category1.getProducts().add(product3);
		
		/*
		 * 연관관계 설정
		 * Product --> Category
		 */
		product1.setCategory(category1);
		product2.setCategory(category1);
		product3.setCategory(category1);
		
		System.out.println("--------------------save[CascadeType.PERSIST]-------------------");
		categoryRepository.save(category1);
		categoryRepository.save(category2);
		
		System.out.println("--------------------read[CascadeType.PERSIST]-------------------");
		Category findCategory1 = categoryRepository.findById(1L).get();
		System.out.println("findCategory1: " + findCategory1);
		System.out.println(findCategory1.getProducts());
		
		System.out.println("--------------------delete-------------------");
		System.out.println("--------------------부모엔티티삭제[CascadeType.REMOVE]-------------------");
		
		System.out.println("--------------------자식엔티티삭제[CascadeType.REMOVE]-------------------");
		
		System.out.println("--------------------부모엔티티삭제[orphanRemoval = true]-------------------");
		
		System.out.println("--------------------자식엔티티삭제[orphanRemoval = true]--------------------");
	
		System.out.println("--------------------부모엔티티와자식엔티티연관관계제거[orphanRemoval = true]??-------------------");
	}
}





