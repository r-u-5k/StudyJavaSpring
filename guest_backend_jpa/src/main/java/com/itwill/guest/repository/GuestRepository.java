package com.itwill.guest.repository;

import com.itwill.guest.dto.GuestDto;
import com.itwill.guest.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    Guest findByGuestNo(int guestNo);

    List<Guest> findByGuestName(String guestName);

    List<Guest> findByGuestTitle(String guestTitle);

    List<Guest> findByGuestContent(String guestContent);
}
