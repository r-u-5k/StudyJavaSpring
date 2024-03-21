package com.itwill.guest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class GuestDaoImpl implements GuestDao {

	public GuestDaoImpl() {
		System.out.println("--> GuestDaoImpl() 기본생성자");
	}

	@Override
	public List<Guest> selectAll() throws Exception {
		System.out.println("--> GuestDaoImpl.selectAll() 메서드 호출");
		List<Guest> guestList = new ArrayList<Guest>();
		guestList.add(new Guest(1, "KIM"));
		guestList.add(new Guest(2, "LEE"));
		return guestList;
	}

	@Override
	public Guest selectByNo(Integer guestNo) throws Exception {
		System.out.println("--> GuestDaoImpl.selectByNo() 메서드 호출");
		return new Guest(guestNo, "이름" + guestNo);
	}

}
