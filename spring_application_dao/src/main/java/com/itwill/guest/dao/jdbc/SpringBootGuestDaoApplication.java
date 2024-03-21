package com.itwill.guest.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class SpringBootGuestDaoApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootGuestDaoApplication.class, args);
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");

	}

}
