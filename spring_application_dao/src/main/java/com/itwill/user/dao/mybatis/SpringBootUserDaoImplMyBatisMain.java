package com.itwill.user.dao.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootUserDaoImplMyBatisMain {
	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=SpringApplication.run(SpringBootUserDaoImplMyBatisMain.class, args);
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		
	
	}

}
