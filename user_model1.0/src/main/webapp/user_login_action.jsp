
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	/*
	0  . GET방식요청일때 user_login_form.jsp로 redirection
	1  . 요청객체 인코딩설정
	2  . 파라메타 받기
	3  . UserService객체생성
	4  . UserService.login() 메쏘드실행
	*/
	
	 
	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공(세션)
	 */
	 
	
	
	
%>