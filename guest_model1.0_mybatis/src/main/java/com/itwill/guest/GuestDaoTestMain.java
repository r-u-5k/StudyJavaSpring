package com.itwill.guest;

import java.util.Date;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		GuestDao guestDao = new GuestDaoImplMyBatis();
//		System.out.println("guestDao: " + guestDao);
		System.out.println(guestDao.insert(Guest.builder().guestName("name")
														  .guestDate(new Date())
														  .guestEmail("email")
														  .guestHomepage("homepage")
														  .guestTitle("title")
														  .guestContent("content")
														  .build()) + "행 insert");
		System.out.println(guestDao.findByGuestNo(16));
		System.out.println(guestDao.findByAll());
		System.out.println(guestDao.update(Guest.builder().guestNo(9)
														  .guestName("updatename")
														  .guestDate(new Date())
														  .guestEmail("updateemail")
														  .guestHomepage("updatehomepage")
														  .guestTitle("updatetitle")
														  .guestContent("updatecontent")
														  .build()) + "행 update");
		System.out.println(guestDao.delete(41) + "행 delete");
	}

}
