package com.itwill.guest.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.guest.dao.GuestDaoImplJPA;
import com.itwill.guest.dto.GuestDto;
import com.itwill.guest.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * - 방명록(guest) 관리 비즈니스로직(업무)를 수행하는 클래스
 * - GUI객체(스윙,서블릿,JSP)에서 직접접근(메쏘드호출)하는클래스
 * - GuestDao객체를 이용해서 데이타베이스에 접근하는클래스
 */
@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    @Qualifier("guestDaoImplJPA")
    private GuestDaoImplJPA guestDaoImplJPA;

    /*
     * 방명록쓰기
     */
    @Override
    public GuestDto guestWrite(GuestDto guestDto) throws Exception {
        Guest guestEntity = Guest.toEntity(guestDto);
        return guestDaoImplJPA.insert(GuestDto.toDto(guestEntity));
    }

    /*
     * 방명록번호로 1개보기
     */
    @Override
    public GuestDto guestDetail(int guest_no) throws Exception {
        return guestDaoImplJPA.findByGuestNo(guest_no);
    }

    /*
     * 방명록번호로삭제
     */
    @Override
    public void guestDelete(int guest_no) throws Exception {
        guestDaoImplJPA.delete(guest_no);
    }

    /*
     * 방명록 리스트보기
     */
    @Override
    public List<GuestDto> guestList() throws Exception {
        return guestDaoImplJPA.findByAll();
    }

    /*
     * 방명록 이름으로검색해서 리스트보기
     */

    public List<GuestDto> findByGuestName(String guest_name) throws Exception {
        return guestDaoImplJPA.findByGuestName(guest_name);
    }

    /*
     * 방명록 전체,이름,제목,내용 으로검색해서 리스트보기
     */

    public List<GuestDto> findByGuest(int searchType, String searchString) throws Exception {
        List<GuestDto> guestDtoList = new ArrayList<GuestDto>();
        switch (searchType) {
            case GUEST_SEARCH_BY_ALL:
                guestDtoList = guestDaoImplJPA.findByAll();
                break;
            case GUEST_SEARCH_BY_NAME:
                guestDtoList = guestDaoImplJPA.findByGuestName(searchString);
                break;
            case GUEST_SEARCH_BY_TITLE:
                guestDtoList = guestDaoImplJPA.findByGuestTitle(searchString);
                break;
            case GUEST_SEARCH_BY_CONTENT:
                guestDtoList = guestDaoImplJPA.findByGuestContent(searchString);
                break;
        }
        return guestDtoList;
    }

    /*
     * 방명록수정
     */
    @Override
    public GuestDto guestUpdate(GuestDto guestDto) throws Exception {
        Guest guestEntity = Guest.toEntity(guestDto);
        return guestDaoImplJPA.update(GuestDto.toDto(guestEntity));
    }

}