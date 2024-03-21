package com.itwill.datasource;

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

	}

}
