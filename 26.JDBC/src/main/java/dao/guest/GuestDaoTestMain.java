package dao.guest;

import dao.guest.erd.GuestDao;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		GuestDao guestDao = new GuestDao();
//		Guest guest = new Guest(0, "test", null, "test@naver.com", "test@test.kr", "제목", "내용");
		Guest guest = Guest.builder()
							.guestContent("내용")
							.guestEmail("enmail@naver.com")
							.guestHomepage("home@page.kr")
							.guestName("익명")
							.guestTitle("제목")
							.build();
		
		System.out.println("1. insert: " + guestDao.insert(guest) + "행 삽입");
		System.out.println("2. findAll: " + guestDao.findAll());
		System.out.println("3. findByGuestNo: " + guestDao.findByGuestNo(3));
		System.out.println("4-1. update form 보여주기");
		Guest updateGuest = guestDao.findByGuestNo(2);
		updateGuest.setGuestName("update");
		updateGuest.setGuestEmail("update@naver.com");
		updateGuest.setGuestHomepage("update@update.kr");
		updateGuest.setGuestTitle("변경제목");
		updateGuest.setGuestContent("변경내용");
		System.out.println("4-2. update 실행: " + guestDao.update(updateGuest) + "행 업데이트");
		System.out.println("5. delete: " + guestDao.delete(15) + "행 삭제");
		
	}

}
