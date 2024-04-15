package com.itwill.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.entity.Guest;

class GuestRepositoryTest extends SpringJpaApplicationTests {
	@Autowired
	GuestRepository guestRepository;
	
	@BeforeEach
	void init() {
		Guest saveGuest1 = Guest.builder()
				/*.guestNo(1L)*/
				.guestName("김경호1")
				/*.guestDate(new Date())*/
				.guestEmail("guard1@gmail.com")
				.guestHomepage("www.guard1.com")
				.guestTitle("제목1")
				.guestContent("내용1")
				.build();
		
		Guest saveGuest2 = Guest.builder()
				/*.guestNo(2L)*/
				.guestName("김경호2")
				/*.guestDate(new Date())*/
				.guestEmail("guard2@gmail.com")
				.guestHomepage("www.guard2.com")
				.guestTitle("제목")
				.guestContent("내용")
				.build();
		
		guestRepository.save(saveGuest1);
		guestRepository.save(saveGuest2);
	}
	
	@Disabled
	@Test
	void save() {
		Guest saveGuest1 = Guest.builder()
				/*.guestNo(1L)*/
				.guestName("김경호1")
				/*.guestDate(new Date())*/
				.guestEmail("guard1@gmail.com")
				.guestHomepage("www.guard1.com")
				.guestTitle("제목1")
				.guestContent("내용1")
				.build();
		
		Guest saveGuest2 = Guest.builder()
				/*.guestNo(2L)*/
				.guestName("김경호2")
				/*.guestDate(new Date())*/
				.guestEmail("guard2@gmail.com")
				.guestHomepage("www.guard2.com")
				.guestTitle("제목")
				.guestContent("내용")
				.build();
		
		Guest guest1 = guestRepository.save(saveGuest1);
		Guest guest2 = guestRepository.save(saveGuest2);
		assertThat(saveGuest1.equals(guest1));
		assertThat(saveGuest2.equals(guest2));
	}
	
	@Test
	void select() {
		Optional<Guest> optional = guestRepository.findById(1L);
		if (optional.isPresent()) {
			Guest guest = optional.get();
			System.out.println(guest);
		} else {
			System.out.println("guest 없음");
		}
		
		System.out.println(guestRepository.findById(1L).get()); // findById
		List<Guest> guestList = guestRepository.findAll(); // findAll
		System.out.println(guestList);
		System.out.println(guestRepository.count()); // count
	}
	
	@Test
	void update() {
		Guest guest1 = guestRepository.findById(1L).get();
		guest1.setGuestName("이경호");
		guestRepository.save(guest1);
	}
	
	@Disabled
	@Test
	void delete() {
		guestRepository.deleteById(1L);
		Guest deleteGuest = Guest.builder().guestNo(3L).build();
		guestRepository.save(deleteGuest);
		guestRepository.delete(deleteGuest);
	}
	
	@Test
	void custom_method() throws ParseException {
		System.out.println(guestRepository.findByGuestNo(10L));
		System.out.println(guestRepository.findAllByOrderByGuestNoDesc());
		System.out.println(guestRepository.findByGuestDateGreaterThan(new SimpleDateFormat("yyyy/MM/dd").parse("2024/04/12")).size());
	}
	
}
