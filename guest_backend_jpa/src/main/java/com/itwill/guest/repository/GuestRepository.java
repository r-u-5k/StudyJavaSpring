package com.itwill.guest.repository;

import com.itwill.guest.dto.GuestDto;
import com.itwill.guest.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface GuestRepository extends JpaRepository<GuestDto, Long> {
	
	GuestDto findByGuestNo(Integer guestNo);
	List<GuestDto> findByGuestNoBetween(Integer no1, Integer no2);
	
	List<GuestDto> findByGuestName(String guestName);
	List<GuestDto> findByGuestNameOrGuestContent(String guestName, String guestContent);
	List<GuestDto> findByGuestNameAndGuestContent(String guestName, String guestContent);
	
	List<GuestDto> findByGuestDateGreaterThan(Date guestDate);
	List<GuestDto> findByGuestDateGreaterThanEqual(Date guestDate);

	List<GuestDto> findByGuestTitle(String guestTitle);

	List<GuestDto> findByGuestContent(String guestContent);

	List<GuestDto> findAllByOrderByGuestNoDesc();
	int removeByGuestName(String guestName);

	int removeByGuestNo(Integer guestNo);

	Boolean existsByGuestName(String guestName);
}
