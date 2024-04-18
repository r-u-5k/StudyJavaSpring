package com.itwill.guest;

import com.itwill.guest.dto.GuestDto;

import java.util.List;

public interface GuestService {

    int GUEST_SEARCH_BY_ALL = 0;
    int GUEST_SEARCH_BY_NAME = 1;
    int GUEST_SEARCH_BY_TITLE = 2;
    int GUEST_SEARCH_BY_CONTENT = 3;

    /*
     * 방명록쓰기
     */
    GuestDto guestWrite(GuestDto guest) throws Exception;

    /*
     * 방명록번호로 1개보기
     */
    GuestDto guestDetail(int guest_no) throws Exception;

    /*
     * 방명록번호로삭제
     */
    void guestDelete(int guest_no) throws Exception;

    /*
     * 방명록 리스트보기
     */
    List<GuestDto> guestList() throws Exception;

    /*
     * 방명록 이름으로검색해서 리스트보기
     */
    public List<GuestDto> findByGuestName(String guest_name) throws Exception;

    /*
     * 방명록 전체,이름,제목,내용 으로검색해서 리스트보기
     */
    public List<GuestDto> findByGuest(int searchType, String searchString) throws Exception;

    /*
     * 방명록수정
     */
    GuestDto guestUpdate(GuestDto guestDto) throws Exception;
}
