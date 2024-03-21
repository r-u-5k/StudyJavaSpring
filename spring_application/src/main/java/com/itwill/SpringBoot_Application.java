package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.guest.GuestService;

@SpringBootApplication
public class SpringBoot_Application {
	
	public static void main(String[] args) throws Exception {
		System.out.println("-------------시작-------------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBoot_Application.class, args);
		GuestService guestService = (GuestService) applicationContext.getBean("guestService");
		System.out.println("-------------끝-------------");
		System.out.println(guestService.guestList());
		System.out.println(guestService.guestDetail(1));
	}
	
}
