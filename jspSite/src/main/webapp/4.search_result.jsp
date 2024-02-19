<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
 * 1. 요청 객체를 사용해서 요청 시 전송되는 쿼리 스트링에 있는 파라메타 받기
 *    - 파라메타 이름은 input element의 name 속성과 일치
 *       <input type="text" name="searchkeyword">
 *    - search?searchkeyword=java   
 */
String searchKeyword = request.getParameter("searchkeyword");
if (searchKeyword == null || searchKeyword.equals("")) {
	out.println("검색어 입력 없음<br>");
	out.println("<a href='4.search_form.jsp'>검색페이지</a>");
	return;
}

/*
 * 2. 검색업무실행 --> Service 객체 사용
 */

/*
 * 3. 클라이언트로 검색 결과 전송
 */
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%out.println(searchKeyword);%> 검색결과</h1>
	<hr>
	<ol>
	<%
		int searchResultCount = (int) (Math.random() * 10);
	%>
	<%for (int i = 0; i < searchResultCount; i++) {%>
		<li><%out.println(searchKeyword);%> 검색결과</li>
	<%}%>
	</ol>
	<a href='4.search_form.jsp'>다시검색</a>
</body>
</html>











