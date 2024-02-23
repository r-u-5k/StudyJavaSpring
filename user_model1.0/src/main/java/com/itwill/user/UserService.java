package com.itwill.user;
/*
 * - 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴포넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
public class UserService {
	
	
	public UserService() throws Exception{
		
	}
	
	/*
	 * 회원가입
	 */
	public int create(User user)throws Exception{
		/*
		 * -1:아이디중복
		 *  1:회원가입성공
		 */
		return 0;
	}
	/*
	 * 회원로그인
	 *  0:아이디존재안함
	 * 	1:패쓰워드 불일치
	 * 	2:로그인성공(세션)
	 */
	public int login(String userId,String password) throws Exception{
		int result=-1;
		
		return result;
	}
	/*
	 * 회원상세보기
	 */
	public User findUser(String userId)throws Exception{
		return null;
	}
	/*
	 * 회원수정
	 */
	public int update(User user)throws Exception{
		return 0;
	}
	
	/*
	 * 회원탈퇴
	 */
	public int remove(String userId)throws Exception{
		return 0;
	}
	
}


















