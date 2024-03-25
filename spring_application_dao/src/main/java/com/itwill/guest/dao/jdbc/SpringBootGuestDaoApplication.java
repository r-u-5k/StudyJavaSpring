package com.itwill.guest.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class SpringBootGuestDaoApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container 초기화 시작 [ApplicationContext 객체 생성 시작]");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootGuestDaoApplication.class, args);
		System.out.println("----Spring Container 초기화 끝 [ApplicationContext 객체 생성 끝]");
		GuestDao guestDao = applicationContext.getBean(GuestDao.class);
		System.out.println(guestDao.selectAll());

	}

}
