package com.itwill.guest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		GuestService guestService = new GuestService();
		List<Guest> guestList = guestService.guestList();
		
		Collections.sort(guestList, new Comparator<Guest>() {

			@Override
			public int compare(Guest o1, Guest o2) {
				return o2.getGuestNo() - o1.getGuestNo();
			}
			
		});
	}

}
