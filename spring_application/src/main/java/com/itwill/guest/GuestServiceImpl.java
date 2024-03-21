package com.itwill.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("guestService")
public class GuestServiceImpl implements GuestService {
	private GuestDao guestDao;
	
	@Autowired
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("--> GuestServiceImpl().setGuestDao() 메서드 호출");
		this.guestDao = guestDao;
	}

	public GuestServiceImpl() {
		System.out.println("--> GuestServiceImpl() 기본생성자");
	}
	
	@Override
	public List<Guest> guestList() throws Exception {
		return guestDao.selectAll();
	}

	@Override
	public Guest guestDetail(Integer guestNo) throws Exception {
		return guestDao.selectByNo(guestNo);
	}

}
