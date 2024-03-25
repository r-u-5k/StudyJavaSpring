package com.itwill.user.dao.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.user.dao.mybatis.SpringBootUserDaoImplMyBatisMain;

@SpringBootApplication
public class SpringBootUserDaoApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container 초기화 시작 [ApplicationContext 객체 생성 시작]");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootUserDaoApplication.class, args);
		System.out.println("----Spring Container 초기화 끝 [ApplicationContext 객체 생성 끝]");
		UserDao userDao = applicationContext.getBean(UserDao.class);
		System.out.println(userDao.findUserList());

	}

}
