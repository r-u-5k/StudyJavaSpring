package com.itwill.jpa.relation.repository;

import com.itwill.jpa.relation.entity.ProductDetail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;

import java.util.Optional;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests {
    @Autowired
    ProductRepository productRepository;

//    @Disabled
    @Transactional
    @Rollback(false)
    @Test
    void productWithCategorySave() {
        Category category1 = Category.builder().code("IT").name("프로그래밍").build();

        Product product1 = Product.builder().name("Spring").price(3000).stock(100).build();
        Product product2 = Product.builder().name("JAVA").price(3200).stock(200).build();
        Product product3 = Product.builder().name("JavaScript").price(2800).stock(150).build();

        /*
         * 연관관계 설정
         * Product --> Category, Category --> Product
         * 양방향 설정 (Owner Table이 아닌 경우)
         */
        product1.setCategory(category1);
        product2.setCategory(category1);
        product3.setCategory(category1);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        Product findProduct = productRepository.findById(1L).get();
        System.out.println(findProduct);
        System.out.println(findProduct.getCategory());

    }

    @Disabled
    @Transactional
    @Rollback(false)
    @Test
    void productWithCategoryRead() {
        System.out.println("------------read------------");
        Product product1 = productRepository.findById(1L).get();
        System.out.println("product1: " + product1);
        System.out.println("product1.getCategory: " + product1.getCategory());
    }

//	@Disabled
    @Transactional
    @Rollback(false)
    @Test
    void productWithProductDetailSave() {
        /*
         * 연관관계설정(OWNER 테이블 X)
         * Product --> ProductDetail
         */
		ProductDetail productDetail = ProductDetail.builder().description("어려워요").build();
		Product product = Product.builder()
				.name("Spring Security")
				.price(6000)
				.stock(400)
				.build();
		/*
		 * 연관관계 설정(OWNER 테이블 X)
		 * Product --> ProductDetail
		 * ProductDetail --> Product
		 */
		product.setProductDetail(productDetail);
		productDetail.setProduct(product);
		productRepository.save(product);
    }

    @Transactional
    @Test
    void productWithProductDetailRead() {
        Optional<Product> optionalProduct = productRepository.findById(2L);
        if (optionalProduct.isPresent()) {
            Product product2 = optionalProduct.get();
            System.out.println("product2: " + product2);
            System.out.println("product2.getProductDetail: " + product2.getProductDetail());
        }
    }

}