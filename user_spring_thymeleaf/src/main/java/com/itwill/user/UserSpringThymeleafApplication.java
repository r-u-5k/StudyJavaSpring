package com.itwill.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserSpringThymeleafApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = SpringApplication.run(UserSpringThymeleafApplication.class, args);

	}

}
