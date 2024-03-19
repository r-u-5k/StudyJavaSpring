<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>기본객체 pageContext[PageContext]</h1>
	<hr />
	<ol>
		<li><%=pageContext.getRequest()%></li>
		<li><%=pageContext.getRequest().getCharacterEncoding()%></li>
		<li><%=pageContext.getRequest().getLocale()%></li>
		<li><%=((HttpServletRequest)pageContext.getRequest()).getMethod()%></li>
		
		<li><%=pageContext.getResponse().getBufferSize()%></li>
		<li><%=pageContext.getResponse().getContentType()%></li>
		
		<li><%=pageContext.getSession()%></li>
		<li><%=pageContext.getSession().getId()%></li>
		<li><%=pageContext.getSession().getMaxInactiveInterval()%></li>
		<li><%=pageContext.getSession().getCreationTime()%></li>
		
		<li><%=pageContext.getServletContext()%></li>
		<li><%=pageContext.getServletConfig()%></li>
	</ol>
</body>
</html>
