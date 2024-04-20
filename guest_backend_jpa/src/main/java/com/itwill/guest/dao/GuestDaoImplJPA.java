package com.itwill.guest.dao;

import com.itwill.guest.dto.GuestDto;
import com.itwill.guest.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("guestDaoImplJPA")
public class GuestDaoImplJPA implements GuestDao {
    @Autowired
    GuestRepository guestRepository;

    @Override
    public GuestDto insert(GuestDto guestDto) throws Exception {
        return guestRepository.save(guestDto);
    }

    @Override
    public GuestDto update(GuestDto guestDto) throws Exception {
        return guestRepository.save(guestDto);
    }

    @Override
    public int delete(int guestNo) throws Exception {
        GuestDto guestDto = guestRepository.findByGuestNo(guestNo);
        return guestRepository.delete(guestDto);
    }

    @Override
    public GuestDto findByGuestNo(int guestNo) throws Exception {
        return guestRepository.findByGuestNo(guestNo);
    }

    @Override
    public List<GuestDto> findByAll() throws Exception {
        return guestRepository.findAll();
    }

    @Override
    public List<GuestDto> findByGuestName(String guestName) throws Exception {
        return guestRepository.findByGuestName(guestName);
    }

    @Override
    public List<GuestDto> findByGuestTitle(String guestTitle) throws Exception {
        return guestRepository.findByGuestTitle(guestTitle);
    }

    @Override
    public List<GuestDto> findByGuestContent(String guestContent) throws Exception {
        return guestRepository.findByGuestContent(guestContent);
    }
}
