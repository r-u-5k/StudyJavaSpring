package com.itwill.guest.dao.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.itwill.guest.dao.mybatis" })
//@MapperScan(basePackages = { "com.itwill.guest.dao.mybatis.mapper" })
public class SpringBootGuestDaoImplMyBatisMain {
	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container 초기화 시작 [ApplicationContext 객체 생성 시작]");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootGuestDaoImplMyBatisMain.class, args);
		System.out.println("----Spring Container 초기화 끝 [ApplicationContext 객체 생성 끝]");
		GuestDao guestDao = applicationContext.getBean(GuestDao.class);
		System.out.println(guestDao.selectAll());
	}

}
