<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("int1", 10);
pageContext.setAttribute("int2", 20);
pageContext.setAttribute("double1", 0.5);
pageContext.setAttribute("double2", 3.14159);
pageContext.setAttribute("string1", "KIM");
pageContext.setAttribute("string2", "경호");
pageContext.setAttribute("bool1", true);
pageContext.setAttribute("bool2", false);
pageContext.setAttribute("married", true);
pageContext.setAttribute("age", 34);
pageContext.setAttribute("weight", 78.23);
pageContext.setAttribute("height", 183);
/*
pageContext.setAttribute("1234", 8888888);
pageContext.setAttribute("3.14159", 777777);
*/
Guest guest = null;
List<Guest> guestList = new ArrayList<Guest>();
Map<String, Guest> guestMap = new HashMap<String, Guest>();
String emptyStr = "";

pageContext.setAttribute("guest", guest);
pageContext.setAttribute("guestList", guestList);
pageContext.setAttribute("guestMap", guestMap);
pageContext.setAttribute("emptyStr", emptyStr);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 리터럴,변수,연산자</h1>
	<hr>
	<ul>
		<li>[1] EL 리터럴 (상수)
			<ul>
				<li>${123}</li>
				<li>${123.123}</li>
				<li>${true}</li>
				<li>${'문자1'}</li>
				<li>${"문자2"}</li>
				<li>${sss}</li><!-- null -->
			</ul>
		</li>

		<li>[2] EL 변수[SCOPE 객체의 속성 이름]
			<ul>
				<li>${int1}</li>
				<li>${int2}</li>
				<li>${double1}</li>
				<li>${double2}</li>
				<li>${string1}</li>
				<li>${string2}</li>
				<li>${bool1}</li>
				<li>${bool2}</li>
				<li>${married}</li>
				<li>${age}</li>
				<li>${weight}</li>
				<li>${height}</li>
			</ul>
		</li>

		<li>[3] EL 연산자
			<ul>
				<li>${23+56}</li>
				<li>${23-56}</li>
				<li>${23/56}</li>
				<li>${23*56}</li>
				<li>${int1 + int2}</li>
				<li>${int1 - int2}</li>
				<li>${int1 / int2}</li>
				<li>${int1 * int2}</li>
				<li>${(int1 - 67) * (int2 + 89)}</li>
				<li>&dollar;{string1 + string2} (X)</li><!-- 문자열 concat 연산자 사용 불가 -->
				<li>${string1}${string2}</li>
				<li>age >= 30 --> ${age >= 30}</li>
				<li>age gt 30 (greater) --> ${age gt 30}</li>
				<li>age lt 30 (little) --> ${age lt 30}</li>
				<li>age ge 30 (greater or equal) --> ${age ge 30}</li>
				<li>age le 30 (little or equal) --> ${age le 30}</li>
				<li>age eq 30 (equal) --> ${age eq 30}</li>
				<li>age ne 30 (not equal) --> ${age ne 30}</li>
			</ul>
		</li>

		<li>[4] null or size 체크
			<ul>
				<li>${guest == null}</li>
				<li>${guestList.size() == 0}</li>
				<li>${guestMap.size() == 0}</li>
				<li>${emptyStr.equals("")}</li>
			</ul>
		</li>

		<li>[5] null or size 체크(empty연산자)
			<ul>
				<li>${empty guest}</li>
				<li>${empty guestList}</li>
				<li>${empty guestMap}</li>
				<li>${empty emptyStr}</li>
			</ul>
		</li>



	</ul>
</body>
</html>