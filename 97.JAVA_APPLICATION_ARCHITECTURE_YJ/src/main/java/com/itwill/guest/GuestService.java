package com.itwill.guest;

import java.util.List;
/*
 * - 방명록(guest) 관리 비즈니스로직(업무)를 수행하는 클래스
 * - GUI객체(스윙,서블릿,JSP)에서 직접접근(메쏘드호출)하는클래스
 * - GuestDao객체를 이용해서 데이타베이스에 접근하는클래스
 */

public class GuestService {
	private GuestDao guestDao;

	public GuestService() throws Exception {
		this.guestDao = new GuestDao();
	}

	/*
	 * 방명록쓰기
	 */
	public int guestWrite(Guest guest) throws Exception {
		/*
		<< GuestDao객체사용>>
		*/
		return 0;
	}

	/*
	 * 방명록번호로 1개보기
	 */
	public Guest guestDetail(int guest_no) throws Exception {
		return null;
	}

	/*
	 * 방명록번호로삭제
	 */
	public int guestDelete(int guest_no) throws Exception {
		return 0;
	}

	/*
	 * 방명록 리스트보기
	 */
	public List<Guest> guestList() throws Exception {
		return null;
	}
	/*
	 * 방명록 이름으로검색해서 리스트보기
	 */

	public List<Guest> findByGuestName(String guest_name) throws Exception {
		return null;
	}

	/*
	 * 방명록수정
	 */
	public int guestUpdate(Guest guest) throws Exception {
		return 0;
	}

}