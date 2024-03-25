package com.itwill.datasource;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDataSourceApplication {
	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container 초기화 시작 [ApplicationContext 객체 생성 시작]");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootDataSourceApplication.class, args);
		System.out.println("----Spring Container 초기화 끝 [ApplicationContext 객체 생성 끝]");
//		DataSource dataSource = applicationContext.getBean(DataSource.class); // dataSource가 여러 개일 땐 불가능
		DataSource dataSource1 = (DataSource) applicationContext.getBean("dataSource1");
		Connection connection1 = dataSource1.getConnection();
		DataSource dataSource2 = (DataSource) applicationContext.getBean("dataSource2");
		Connection connection2 = dataSource2.getConnection();
		System.out.println(dataSource1);
		System.out.println(connection1);
		System.out.println(dataSource2);
		System.out.println(connection2);

	}

}
