package com.itwill2.beanCreate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductService;
/*
 * @SpringBootApplication
 *  - 현재 클래스가 위치하는 패키지와 하위 패키지의 클래스의 
	  @Annotation을 스캔해서 초기화 (객체 생성, 의존성 주입)
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.product"})
public class SpringBootBeanCreateApplicationMain {

	public static void main(String[] args) {
		System.out.println("----------Spring Container 초기화 시작[ApplicationContext 객체 생성 시작]--------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanCreateApplicationMain.class, args);
		System.out.println("-----------Spring Container 초기화 끝 [ApplicationContext 객체 생성 끝]----------");
		
		System.out.println("-------스프링 컨테이너에 등록된 빈 클래스로 스프링빈 객체 참조 얻기--------");
		ProductDao productDao1 = applicationContext.getBean(ProductDao.class);
		ProductService productService1 = applicationContext.getBean(ProductService.class);
		System.out.println(productDao1);
		System.out.println(productService1);
		
		System.out.println("-------스프링 컨테이너에 등록된 빈 아이디로 스프링빈 객체 참조 얻기--------");
		ProductDao productDao2 = (ProductDao) applicationContext.getBean("productDao");
		ProductService productService2 = (ProductService) applicationContext.getBean("productService");
		System.out.println(productDao2);
		System.out.println(productService2);
		
		System.out.println("----------빈의 @Scope(singleton)----------");
		System.out.println(applicationContext.getBean(ProductDao.class));
		System.out.println(applicationContext.getBean(ProductDao.class));
		System.out.println(applicationContext.getBean(ProductService.class));
		System.out.println(applicationContext.getBean(ProductService.class));
		
	}

}
