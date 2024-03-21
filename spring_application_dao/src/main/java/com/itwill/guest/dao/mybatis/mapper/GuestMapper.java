package com.itwill.guest.dao.mybatis.mapper;

import java.util.List;

import com.itwill.guest.dao.mybatis.Guest;

public interface GuestMapper {
	
	List<Guest> selectAll() throws Exception;
	Guest selectByNo(int no) throws Exception;
	int insertGuest(Guest guest) throws Exception;
	int updateGuest(Guest guest) throws Exception;
	int deleteGuest(int no) throws Exception;
}