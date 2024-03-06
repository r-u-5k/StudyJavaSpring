package com.itwill.shop.product;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductDaoImplJDBCTest {
	ProductDao productDao;
	@BeforeEach
	void setUp() throws Exception {
		productDao = new ProductDaoImplJDBC();
	}

	@Test
	void testFindByPrimaryKey() throws Exception {
		Product product = productDao.findByPrimaryKey(1);
		assertTrue(product.getP_name().equals("비글"));
	}

	@Test
	void testFindAll() throws Exception {
		List<Product> products = productDao.findAll();
		assertNotEquals(products, null);
	}

}
