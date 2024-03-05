<%@ page contentType="text/html; charset=UTF-8"%>
<%!
int count = 0;
public void jspInit() {
	System.out.println("1. init 메서드 --> 생성자 호출 직후에 단 한 번 호출 [객체 초기화, 리소스 획득]");
}
public void jspDestroy() {
	System.out.println("3. destroy 메서드 --> 서블릿 객체가 메모리에서 해제되기 직전에 호출 [리소스 반납]");
}
%>
<%
System.out.println("2. service 메서드 실행 [요청 시마다 호출]: " + this);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
			<body bgcolor=#40e0d0 style=font-size:9pt;line-height:140%;> 
			<center>			
			 현재까지의 페이지뷰수
			<font color=#0000FF>
			 <%
			 out.println(++count);
			 %>
			</font>
			 명입니다 
			</center> 
			</body> 
</html> 
