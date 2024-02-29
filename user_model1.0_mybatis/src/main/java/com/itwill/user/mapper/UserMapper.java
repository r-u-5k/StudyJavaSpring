package com.itwill.user.mapper;

import java.util.List;

import com.itwill.user.User;

public interface UserMapper {
	
	int insert(User user) throws Exception;

	
	int update(User user) throws Exception;

	
	int delete(String userId) throws Exception;

	
	User findUser(String userId) throws Exception;

	
	List<User> findUserList() throws Exception;

	
	int countByUserId(String userId) throws Exception;
	
	
}