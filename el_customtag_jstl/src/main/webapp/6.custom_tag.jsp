<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="itwill" uri="http://www.itwill.co.kr/jsp/simpleTag"%>	
<%
session.setAttribute("sUserId", "guard");
request.setAttribute("name", "현빈");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Custom Tag [사용자 정의 태그]</h1>
	<hr />
	---------------hello tag----------------------<br>
	<itwill:hello/>
	
	---------------helloAttr tag----------------------<br>
	<itwill:helloAttr name="${name}"/>
	
	---------------if tag[body]----------------------<br>
	<itwill:if test="${sUserId == null}">
		<a href="user_login_form.jsp">로그인</a>
	</itwill:if>
	<itwill:if test="${sUserId != null}">
		<a href="user_logout_form.jsp">${sUserId}님 로그아웃</a>
	</itwill:if>


</body>
</html>