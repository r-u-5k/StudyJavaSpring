package com.itwill.guest.service;

import com.itwill.guest.dto.GuestDto;

import java.util.List;

public interface GuestService {

    int GUEST_SEARCH_BY_ALL = 0;
    int GUEST_SEARCH_BY_NAME = 1;
    int GUEST_SEARCH_BY_TITLE = 2;
    int GUEST_SEARCH_BY_CONTENT = 3;

    /*
     * 방명록 쓰기
     */
    GuestDto guestWrite(GuestDto guest) throws Exception;

    /*
     * 방명록 번호로 1개 보기
     */
    GuestDto guestDetail(int guest_no) throws Exception;

    /*
     * 방명록 번호로 삭제
     */
    void guestDelete(int guest_no) throws Exception;

    /*
     * 방명록 리스트 보기
     */
    List<GuestDto> guestList() throws Exception;

    /*
     * 방명록 전체, 이름, 제목, 내용으로 검색해서 리스트 보기
     */
    List<GuestDto> findByGuest(int searchType, String searchString) throws Exception;

    /*
     * 방명록 수정
     */
    GuestDto guestUpdate(GuestDto guestDto) throws Exception;
}
