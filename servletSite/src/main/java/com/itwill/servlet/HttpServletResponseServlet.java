package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/response")
public class HttpServletResponseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*
		 * http://192.168.15.31/response?cmd=1
		 * http://192.168.15.31/response?cmd=2
		 * http://192.168.15.31/response?cmd=13234243
		 * http://192.168.15.31/response?cmd=
		 * http://192.168.15.31/response?
		 */
		
		String cmd = request.getParameter("cmd");
		if (cmd == null || cmd.equals("")) {
			/* case 1
			out.println("<h1>다시 요청하세요</h1><hr>");
			out.println("<a href='04.HttpServletResponse.html'>04.HttpServletResponse.html</a>");
			return;
			*/
			/* case 2 */
			response.sendRedirect("04.HttpServletResponse.html");
			return;
		}
		
		if (cmd.equals("1")) {
			/*
			 * 정상응답
			 *   1. 응답 라인 상태코드 200
			 *   2. 응답 헤더
			 *   3. 응답 바디(데이터)
			 */
			out.println("<h3>정상응답</h3><hr>");
		} else if (cmd.equals("2")) {
			/*
			 * 에러응답
			 *   1. 응답 라인 상태코드 4__, 5__
			 *   2. 응답 헤더
			 *   (응답 바디(데이터) 없음)
			 */
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "메세지 없음");
		} else if (cmd.equals("3")) {
			/*
			 * 리다이렉트[방향재지정]응답
			 *   1. 응답 라인 상태코드 302
			 *   2. 응답 헤더[Location: 05-03.form1.html(Redirection URL)이 포함됨]
			 *   (응답 바디(데이터) 없음)
			 */
			response.sendRedirect("index.html");
		}
		
	}
}
