<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
/*
 * 0. 요청객체 인코딩설정
 */
response.setContentType("text/html;charset=UTF-8");

/*
 * 1.파라메타바끼
 *	아이디:<input type="text" name="id">
 *  패에쓰:<input type="password" name="pass">
 */
String id = request.getParameter("id");
String pass = request.getParameter("pass");
if (id == null || pass == null || id.equals("") || pass.equals("")) {
	out.println("<h1>GET 로그인 결과</h1><hr>");
	out.println("<h3>아이디 또는 패스워드가 입력되지 않음</h3>");
	out.println("<a href='4.login_get_form.jsp'>다시 로그인</a>");
	return;
}

/*
 * 2.업무실행(DB)
 *   id |pass
 *  ---------
 *  xxxx|1111
 *  yyyy|2222
 */
boolean isMember1 = id.equals("xxxx") && pass.equals("1111");
boolean isMember2 = id.equals("yyyy") && pass.equals("2222");

/*
 * 3.클라이언트로 출력
 */
out.println("<h1>GET 로그인 결과</h1><hr>");
if (isMember1 || isMember2) {
	/* case 1
	out.println("<h3>" + id + "님 로그인 성공</h3>");
	out.println("<a href='index.jsp'>메인으로</a>");
	*/
	/* case 2 */
	response.sendRedirect("index.jsp");
} else {
	out.println("<h3>" + id + "님 로그인 실패</h3>");
	out.println("<a href='4.login_get_form.jsp'>다시 로그인</a>");
}
%>
