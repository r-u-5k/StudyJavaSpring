package com.itwill.guest.dao;

import com.itwill.guest.dto.GuestDto;
import com.itwill.guest.entity.Guest;
import com.itwill.guest.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("guestDaoImplJPA")
public class GuestDaoImplJPA implements GuestDao {
    @Autowired
    GuestRepository guestRepository;

    @Override
    public int insert(GuestDto guestDto) throws Exception {
        Guest guestEntity = Guest.toEntity(guestDto);
        guestRepository.save(GuestDto.toDto(guestEntity));
        return 0;
    }

    @Override
    public int update(GuestDto guestDto) throws Exception {
        Guest guestEntity = Guest.toEntity(guestDto);
        guestRepository.save(guestDto);
        return 0;
    }

    @Override
    public void delete(int guestNo) throws Exception {
        Guest guestEntity = guestRepository.findByGuestNo(guestNo);
        guestRepository.delete();
    }

    @Override
    public GuestDto findByGuestNo(int guestNo) throws Exception {
        Guest guestEntity = guestRepository.findByGuestNo(guestNo);
        return GuestDto.toDto(guestEntity);
    }

    @Override
    public List<GuestDto> findByAll() throws Exception {
        List<Guest> guestEntityList = guestRepository.findAll();
        List<GuestDto> guestDtoList = new ArrayList<>();
        for (Guest guestEntity : guestEntityList) {
            guestDtoList.add(GuestDto.toDto(guestEntity));
        }
        return guestDtoList;
    }

    @Override
    public List<GuestDto> findByGuestName(String guestName) throws Exception {
        List<Guest> guestEntityList = guestRepository.findByGuestName(guestName);
        List<GuestDto> guestDtoList = new ArrayList<>();
        for (Guest guestEntity : guestEntityList) {
            guestDtoList.add(GuestDto.toDto(guestEntity));
        }
        return guestDtoList;
    }

    @Override
    public List<GuestDto> findByGuestTitle(String guestTitle) throws Exception {
        List<Guest> guestEntityList = guestRepository.findByGuestTitle(guestTitle);
        List<GuestDto> guestDtoList = new ArrayList<>();
        for (Guest guestEntity : guestEntityList) {
            guestDtoList.add(GuestDto.toDto(guestEntity));
        }
        return guestDtoList;
    }

    @Override
    public List<GuestDto> findByGuestContent(String guestContent) throws Exception {
        List<Guest> guestEntityList = guestRepository.findByGuestContent(guestContent);
    }
}
