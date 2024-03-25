package com.itwill.user.dao.mybatis;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.user.dao.mybatis.mapper.UserMapper;

@SpringBootApplication
public class SpringBootUserDaoImplMyBatisMain {
	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container 초기화 시작 [ApplicationContext 객체 생성 시작]");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootUserDaoImplMyBatisMain.class, args);
		System.out.println("----Spring Container 초기화 끝 [ApplicationContext 객체 생성 끝]");
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource);
		System.out.println(applicationContext.getBean(User.class));
//		System.out.println(applicationContext.getBean("user"));
		System.out.println(applicationContext.getBean(UserDao.class));
		System.out.println(applicationContext.getBean(UserMapper.class));

		UserDao userDao = applicationContext.getBean(UserDao.class);
		System.out.println(userDao.findUserList());
		System.out.println(userDao.findUser("f"));
	}

}
