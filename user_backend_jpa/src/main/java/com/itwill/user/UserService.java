package com.itwill.user;

import com.itwill.user.exception.ExistedUserException;

public interface UserService {

	/*
	 * 회원가입
	 */
	int create(User user) throws  ExistedUserException,Exception;

	/*
	 * 회원로그인
	 *  0:아이디존재안함
	 * 	1:패쓰워드 불일치
	 * 	2:로그인성공(세션)
	 */
	int login(String userId, String password) throws Exception;

	/*
	 * 회원상세보기
	 */
	User findUser(String userId) throws Exception;

	/*
	 * 회원수정
	 */
	int update(User user) throws Exception;

	/*
	 * 회원탈퇴
	 */
	int remove(String userId) throws Exception;
	/*
	 * 아이디중복체크
	 */
	boolean isDuplicateId(String userId) throws Exception;
}