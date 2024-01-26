package com.itwill.member;

import java.util.List;

public class MemberService {
	private MemberDao memberDao;

	public MemberService() throws Exception {
		memberDao = new MemberDao();
	}

	/*
	 * 회원가입
	 */
	public boolean addMember(Member newMember) throws Exception {
		boolean isSuccess = false;
		/*
		 * 아이디존재여부
		 */

		return isSuccess;
	}

	/*
	 * 회원로그인
	 */
	public Member login(String memberId, String memberPassword) throws Exception {
		return null;
	}

	/*
	 * 회원아이디중복체크
	 */

	/*
	 * 회원상세보기
	 */
	public Member memberDetail(String memberId) throws Exception {
		return null;
	}

	/*
	 * 회원수정
	 */
	public int memberUpdate(Member member) throws Exception {
		return 0;
	}

	/*
	 * 회원탈퇴
	 */
	public int memberDelete(String memberId) throws Exception {
		return 0;
	}

	/************************* admin ***************************/
	/*
	 * 회원전체리스트
	 */
	public List<Member> memberList() throws Exception {
		return null;
	}
	/* 
	 * 회원이름으로검색
	 * 회원주소로검색
	 * 회원나이로검색
	 * 회원결혼여부로검색
	 * 회원가입일로검색
	 */
}
