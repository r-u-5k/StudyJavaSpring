<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>

<style type="text/css">
a:link {
	color: #FFFFFF
}

a:visited {
	color: #FFFFFF
}

a:hover {
	color: #00FF00
}

a.m1 {
	font-size: 9pt;
	text-decoration: underline;
	COLOR: #0000FF
}

a.m1:visited {
	font-size: 9pt;
	text-decoration: underline;
	COLOR: #0000FF
}

a.m1:active {
	font-size: 9pt;
	text-decoration: underline;
	COLOR: #0000FF
}

a.m1:hover {
	font-size: 9pt;
	text-decoration: underline;
	COLOR: #FF3300
}

a.m2 {
	font-size: 10pt;
	text-decoration: none
}

a.m2:visited {
	font-size: 10pt;
	text-decoration: none
}

a.m2:active {
	font-size: 10pt;
	text-decoration: none
}

a.m2:hover {
	font-size: 10pt;
	text-decoration: none
}

.menu {
	color: #ffffff;
	font-size: 11pt;
	font-weight: bold;
}

.t1 {
	font-size: 9pt;
	line-HEIGHT: 140%;
}

.t2 {
	font-size: 10pt;
}

.TXTFLD {
	FONT-SIZE: 9pt;
	COLOR: #000000;
	BORDER: 1x SOLID #000000
}

.TXTFLD1 {
	FONT-SIZE: 9pt;
	COLOR: #0]00000;
	BORDER: 0 SOLID #000000
}
</style>
</head>

<body>
	<br>
	<table width="80%" border="0" cellspacing="0" cellpadding="2"
		align="center">

		<tr bgcolor=#a52a2a valign="middle">
			<td height="25" class="t1" align="center" bgcolor="#A52E78"><b><font
					size="3" color="#FFFFFF">◇◇◇ 세&nbsp;&nbsp; 션 ◇◇◇</font></b></td>
		</tr>

		<tr>
			<td height="100" class="t1"><br> <br> 세션이란 일정 시간동안(디폴트 30분) 
			같은 사용자(정확히 말하면 같은 브라우저)로 부터 들어오는<br> 일련의 요구들 하나의
				상태로 보고 그 상태를 일정하게 유지시키는 기술이다.<br> <br> 예를 들어서 쇼핑몰에서 장바구니를
				구현할 때 매우 유용하게 사용될 수 있다. 즉 쇼핑몰에서 사용자가<br> 상품을 주문할 때마다 그 사용자에 대한
				상품을 세션으로 저장해 두면 나중에 한 번에 구매한 물품을 <br> 세션에 저장된 정보에서 볼러올 수 있는
				것입니다.<br> <br> <font color="#0000FF">서블릿에서 세션은
					HttpSession 인터페이스로 표현된다. 실제로 HttpSession 인터페이스를 임플리먼츠하는<br>
					클래스는 서블릿 컨테이너(엔진)에의해 만들어 지며, 서블릿에서 세션 객체를 얻고자 할 경우에는<br>
			</font><font color="#FF0000"><b>HttpServletRequest의
						getSession(true); 메소드에 얻을 수 있다.</b></font><font color="#0000FF"> 얻어진
					세션 객체는 유일한 ID값<br> (
			</font><font color="#FF0000">세션아이디</font><font color="#0000FF">)을
					부여받으므로써 각각의 클라이언트를 구별한다.<br>
			</font><br></td>
		</tr>

		<tr>
			<td>
				<table width="100%" align="center" border="1" cellspacing="0"
					cellpadding="3" bordercolordark="white" bordercolorlight="#000000">
					<tr bgcolor="#556b2f">
						<td align="center" height="25" class="t1"><b><font
								size="2" color="#FFFFFF">◐ 세션 트레킹 방법(세션 아이디 전달 방법) ◑</font></b></td>
					</tr>

					<tr bgcolor="#f0fff3">
						<td align="left" class="t1"><br> <font color="#FF00FF"><b>●
									쿠키를 이용한 전달</b></font><br> 가장 쉬우면서 가장 많이 사용하는 방법으로 세션이 생성되면 가지게 되는 유일한
							아이디값을<br> <font color="#0000CC">JSESSIONID</font>라는 쿠키 이름으로
							값을 설정하여 클라이언트에 전달하는 방법이다.<br> <br> 브라우저는 디폴트로 세션단위 쿠키를
							허용하기 때문에 쉽게 구현할 수 있다.<br> <br> <br> <font
							color="#FF00FF"><b>● URL rewriting을 이용한 전달</b></font><br>
							쿠키를 이용하는 세션아이디를 전달하는 방법은 간단하나, 사용자가 웹브라우저의 세션 단위 쿠키를<br>
							허용하지 않는 경우에는 사용할 수 없게 된다.<br> <br> 이러한 단점을 보완하여 나온것이
							URL rewriting 방법인데 URL의 쿼리스트링 부분에 세션아이디를<br> 추가하여 클라이언트에
							전달하는 방법이다.<br> <br> [예]
							http://ip:8080/servlet/ServletName<b><font color="#0000FF">;JSESSIONID=To1018mc4894848848484AT<br>
									<br>
							</font></b>&nbsp;&nbsp;&nbsp;&nbsp;▶ URL Rewriting을 사용하려면
							HttpServletResponse의 encodeURL()메소드를 사용해서 인코딩<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 해야 한다.<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#0000FF"><b>→
									String newURL = res.encodeURL(url);<br>
							</b></font><br> <br> <font color="#FF00FF"><b>● URL
									rewriting을 이용한 전달</b></font><br> HTML의 FORM 태그의 HIDDEN 타입으로 세션아이디를
							클라이언트에 전달하는 방법이다.<br> <br> [예] <font color="#0000FF"><b>&lt;INPUT
									TYPE=&quot;HIDDEN&quot; NAME=&quot;name&quot;
									VALUE=&quot;value&quot;&gt;<br>
							</b></font><br>&nbsp;&nbsp;&nbsp;&nbsp; <b><font color="#0000CC">
									<br>
							</font></b></td>
					</tr>

				</table>
			</td>
		</tr>

		<tr>
			<td><br> <br>
				<table width="100%" align="center" border="1" cellspacing="0"
					cellpadding="3" bordercolordark="white" bordercolorlight="#000000">
					<tr bgcolor="#556b2f">
						<td align="center" height="25" class="t1"><b><font
								size="2" color="#FFFFFF">◐ 세션을 얻어내는 방법 ◑</font></b></td>
					</tr>

					<tr bgcolor="#f0fff3">
						<td align="left" class="t1"><br> <b> <font
								color="#FF00FF">● HttpServletRequest 객체의 getSession(true)</font></b><b><font
								color="#FF00FF">메소드를 이용하여 세션을 얻는다.</font></b><br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▶ 주의할점은 getSession() 메소드를 콜하기 전에
							HttpServletResponse 의 메소드를 먼저<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 호출해서는 안된다.<br>
							<br> [예] <font color="#0000FF"><b>HttpSession
									session = req.getSession(true);<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; PrintWriter out =
									res.getWriter();
							</b></font><br>&nbsp;&nbsp;&nbsp;&nbsp; <b><font color="#0000CC">
									<br>
							</font></b></td>
					</tr>
				</table></td>
		</tr>

		<tr>
			<td><br> <br>
				<table width="100%" align="center" border="1" cellspacing="0"
					cellpadding="3" bordercolordark="white" bordercolorlight="#000000">
					<tr bgcolor="#556b2f">
						<td align="center" height="25" class="t1"><b><font
								size="2" color="#FFFFFF">◐ 세션에 데이터를 저장하고 얻어오는 주요 메소드 ◑</font></b></td>
					</tr>

					<tr bgcolor="#f0fff3">
						<td align="left" class="t1"><br> <b> <font
								color="#FF00FF">● vod setAttribute(String name, Object
									value);</font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 세션객체에 name이라는 이름으로 value값을 저장한다.<br>
							<br> <b> <font color="#FF00FF">● Object
									getAttribute(String name);</font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 주어진 name으로 저장된 값을 Object 타입으로
							리턴한다.<br> <br> <font color="#FF00FF"> <b> ●
									Enumeration getAttributeNames();<br>
							</b></font>&nbsp;&nbsp;&nbsp; 세션객체에 저장된 모든 값의 이름을 Enumeration 타입으로 리턴한다.<br>
							<br> <font color="#FF00FF"><b>● String getId();<br>
							</b></font>&nbsp;&nbsp;&nbsp; 생성된 세션의 유일한 세션아이디를 리턴해 준다.<br> <br>

							<font color="#FF00FF"> <b> ● long getCreationTime();<br>
							</b></font>&nbsp;&nbsp;&nbsp; 1970년 1월 1일 0시 0분 0초를 기준으로 세션이 생성된 시간을 리턴해
							준다(단위: ms).&nbsp;<br> <br> <font color="#FF00FF">

								<b> ● long getLastAccessedTime();<br>
							</b>
						</font>&nbsp;&nbsp;&nbsp; 클라이언트가 이 세션에 관계된 요구를 한 가장 최근의 시간을 리턴해 준다.<br>
							<br> <font color="#FF00FF"><b>● int
									getMaxInactiveInterval();<br>
							</b></font>&nbsp;&nbsp;&nbsp; 서버가 클라이언트의 요청이 없을 경우 세션을 유지하는 시간을 리턴해 준다.(디폴트
							30분)<br> <br> <font color="#FF00FF"><b>●
									boolean isNew();<br>
							</b></font>&nbsp;&nbsp;&nbsp; 세션이 생성되긴 하였지만 클라이언트가 아직 세션 정보를 연결하지 않았을 경우
							true를 리턴한다.<br> <br> <font color="#FF00FF"><b>●
									void removeAttribute(String name);<br>
							</b></font>&nbsp;&nbsp;&nbsp; 주어진 이름의 값(객체)을 세션에서 제거할 경우 사용한다.<br> <br>
							<font color="#FF00FF"><b>● void invalidate();<br>
							</b></font>&nbsp;&nbsp;&nbsp; 현재 설정되어 있는 세션을 삭제할 경우 사용합니다.<br>
							&nbsp;&nbsp;&nbsp; <b><font color="#0000CC"> <br>
							</font></b></td>
					</tr>
				</table></td>
		</tr>

	</table>

	<br>
	<br>



</body>
</html>
