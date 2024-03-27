package com.itwill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.user.mapper.UserMapper;
@Repository
public class UserDaoImplMyBatis implements UserDao {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int update(User user) throws Exception {
		return userMapper.update(user);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return userMapper.findUser(userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return userMapper.findUserList();
	}

	@Override
	public int insert(User user) throws Exception {
		return userMapper.insert(user);
	}

	@Override
	public int delete(String userId) throws Exception {
		return userMapper.delete(userId);
	}

	@Override
	public int countByUserId(String userId) throws Exception {
		return userMapper.countByUserId(userId);
	}

}