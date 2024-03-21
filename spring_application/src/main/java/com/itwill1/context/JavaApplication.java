package com.itwill1.context;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestDaoImpl;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class JavaApplication {

	public static void main(String[] args) throws Exception {
		GuestDao guestDao = new GuestDaoImpl();
		GuestServiceImpl guestService = new GuestServiceImpl();
		guestService.setGuestDao(guestDao);
		
		System.out.println(guestService.guestList());
		System.out.println(guestService.guestDetail(1));
	}

}
