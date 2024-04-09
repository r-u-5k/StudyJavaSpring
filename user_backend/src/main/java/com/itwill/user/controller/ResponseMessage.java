package com.itwill.user.controller;


public class ResponseMessage {
	

    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String CREATED_USER = "회원가입 성공";
    public static final String UPDATE_USER = "회원정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";
    public static final String LOGOUT_USER = "로그아웃";

	
	
    public static final String LOGIN_FAIL_NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String LOGIN_FAIL_PASSWORD_MISMATCH_USER = "패스워드 불일치";
    public static final String CREATE_FAIL_EXISTED_USER = "아이디 중복";
    public static final String UNAUTHORIZED_USER = "인증받지 않은 요청입니다.";
    
}