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
    public GuestDto insert(GuestDto guestDto) throws Exception {
         Guest guestEntity = guestRepository.save(Guest.toEntity(guestDto));
         return GuestDto.toDto(guestEntity);
    }

    @Override
    public GuestDto update(GuestDto guestDto) throws Exception {
        Guest guestEntity = guestRepository.save(Guest.toEntity(guestDto));
        return GuestDto.toDto(guestEntity);
    }

    @Override
    public void delete(int guestNo) throws Exception {
        Guest guestEntity = guestRepository.findByGuestNo(guestNo);
        guestRepository.delete(guestEntity);
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
        List<Guest> guestEntityList = guestRepository.findByGuestNameContaining(guestName);
        List<GuestDto> guestDtoList = new ArrayList<>();
        for (Guest guestEntity : guestEntityList) {
            guestDtoList.add(GuestDto.toDto(guestEntity));
        }
        return guestDtoList;
    }

    @Override
    public List<GuestDto> findByGuestTitle(String guestTitle) throws Exception {
        List<Guest> guestEntityList = guestRepository.findByGuestTitleContaining(guestTitle);
        List<GuestDto> guestDtoList = new ArrayList<>();
        for (Guest guestEntity : guestEntityList) {
            guestDtoList.add(GuestDto.toDto(guestEntity));
        }
        return guestDtoList;
    }

    @Override
    public List<GuestDto> findByGuestContent(String guestContent) throws Exception {
        List<Guest> guestEntityList = guestRepository.findByGuestContentContaining(guestContent);
        List<GuestDto> guestDtoList = new ArrayList<>();
        for (Guest guestEntity : guestEntityList) {
            guestDtoList.add(GuestDto.toDto(guestEntity));
        }
        return guestDtoList;
    }
}
