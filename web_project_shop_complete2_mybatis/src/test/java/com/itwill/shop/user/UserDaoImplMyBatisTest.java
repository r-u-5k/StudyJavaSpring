package com.itwill.shop.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.notNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.GreaterThan;

class UserDaoImplMyBatisTest {
	UserDao userDao;
	@BeforeEach
	void setUp() throws Exception {
		userDao=new UserDaoImplMyBatis();
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testFindUser() {
		fail("Not yet implemented");
	}

	@Test
	void testFindUserList()  throws Exception{
		assertNotEquals(userDao.findUserList(), null);
		assertEquals(userDao.findUserList().size(),20 );
		assertTrue(userDao.findUserList().size() > 0 );
		
	}

	@Test
	void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testCountByUserId() {
		fail("Not yet implemented");
	}

}
