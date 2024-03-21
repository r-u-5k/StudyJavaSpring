package com.itwill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.GuestService;

public class Spring_Application {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill/0.application_context.xml");
		
		GuestService guestService = (GuestService) applicationContext.getBean("guestService");
		
		System.out.println(guestService.guestList());
		System.out.println(guestService.guestDetail(1));
		
	}

}
