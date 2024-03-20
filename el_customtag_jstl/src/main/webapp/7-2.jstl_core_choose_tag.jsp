<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//session.setAttribute("sUserId", "admin");
session.setAttribute("sUserId", "guard");
request.setAttribute("level", 2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL core choose tag</h1>
	<hr>
	<c:choose>
		<c:when test="${!empty sUserId}">
			<a href="">${sUserId}님 로그아웃</a>
			<a href="">상품 리스트</a>
			<c:if test="${sUserId == 'admin'}"><!-- equals 써도 됨 -->
				<a href="">상품 등록</a>
			</c:if>
		</c:when>
		<c:otherwise>
			<a href="">로그인</a>
		</c:otherwise>
	</c:choose>
	<br>
	<c:choose>
		<c:when test="${level == 1}">
			초보[${level}레벨]
		</c:when>
		<c:when test="${level == 2}">
			중수[${level}레벨]
		</c:when>
		<c:when test="${level == 3}">
			고수[${level}레벨]
		</c:when>
		<c:otherwise>
			레벨은 1~3 사이입니다.
		</c:otherwise>
	</c:choose>














</body>
</html>