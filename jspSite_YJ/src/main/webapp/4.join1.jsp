<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("4.form1.jsp");
	return;
}
String id = request.getParameter("id");
String password = request.getParameter("password");
String email1 = request.getParameter("email1");
String email2 = request.getParameter("email2");
String email = email1 + "@" + email2;
String gender = request.getParameter("gender");
String[] favorites = request.getParameterValues("favorite");
if (favorites == null) {
	favorites = new String[0];
}
String message = request.getParameter("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>가입정보</h1>
	<ul>
		<li>아이디: <%=id %>
		<li>패스워드: <%=password %>
		<li>이메일: <%=email %>
		<li>성별: <%=gender %>
		<li>관심사
			<ul>
			<%for (String favorite : favorites) { %>
				<li><%=favorite %>
			<%} %>
			</ul>
		<li>가입인사: <%=message %>
	</ul>
<a href='4.form1.jsp'>가입폼</a>
</body>
</html>