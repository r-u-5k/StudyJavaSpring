<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
session.setAttribute("sUserId", "guard");
request.setAttribute("level", 4);
request.setAttribute("guest", new Guest());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL core if tag</h1>
	<hr />
	<c:if test="true">
		1. 반드시 실행<br>
	</c:if>
	<c:if test="false">
		2. 반드시 실행X<br>
	</c:if>
	<c:if test="${sUserId != null}">
		<a href="">${sUserId}님 로그아웃</a><br>
	</c:if>
	<c:if test="${empty sUserId}">
		<a href="">로그인</a><br>
	</c:if>
	<c:if test="${!empty level}">
		<c:if test="${level ge 3 && level lt 4}">
			${level}레벨이군요.
		</c:if>
		<c:if test="${level ge 4 && level lt 5}">
			${level}레벨 ㄷㄷ
		</c:if>
	</c:if>
</body>
</html>