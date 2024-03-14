<%@page import="com.itwill.student.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
System.out.println("6-1.action_tag_forward.jsp");
/*
Forwarding
  - 6-1.action_tag_forwarded.jsp로 HTTP 요청 보냄
  - request 객체에 속성 객체를 담음
*/
request.setAttribute("id", "guard");
request.setAttribute("name", "김경호");
request.setAttribute("age", 30);
request.setAttribute("student", new Student());
/* response.sendRedirect("6-1.action_tag_forwarded.jsp"); */

RequestDispatcher rd = request.getRequestDispatcher("6-1.action_tag_forwarded.jsp");
rd.forward(request, response);
%>
<%-- <jsp:forward page="./6-1.action_tag_forwarded.jsp"></jsp:forward> --%>
