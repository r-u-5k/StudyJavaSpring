package com.itwill.guest.repository;

import com.itwill.guest.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    Guest findByGuestNo(int guestNo);

    List<Guest> findByGuestNameContaining(String guestName);

    List<Guest> findByGuestTitleContaining(String guestTitle);

    List<Guest> findByGuestContentContaining(String guestContent);
}
