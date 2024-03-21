package com.itwill3.DI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductService;
import com.itwill.user.UserService;
/*
 * @SpringBootApplication
 *  - 현재 클래스가 위치하는 패키지와 하위 패키지의 클래스의 
	  @Annotation을 스캔해서 초기화 (객체 생성, 의존성 주입)
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.user"})
public class SpringBootDependencyInjectionApplicationMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----------Spring Container 초기화 시작 [ApplicationContext 객체 생성 시작]--------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootDependencyInjectionApplicationMain.class, args);
		System.out.println("-----------Spring Container 초기화 끝 [ApplicationContext 객체 생성 끝]----------");
		
		UserService userService = applicationContext.getBean(UserService.class);
		System.out.println(userService.findUserList());
		
	}

}
