package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
  web.xml설정
  <servlet>
  	<servlet-name>annotation_mapping</servlet-name>
  	<servlet-class>com.itwill.servlet.AnnotationMappingServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>annotation_mapping</servlet-name>
  	<url-pattern>/annotation_mapping.do</url-pattern>
  </servlet-mapping>
 */
/*
 * web.xml대신에 annotation[@] 사용
 */
@WebServlet(name = "annotation_mapping", urlPatterns = "/annotation_mapping")
//@WebServlet("/annotation_mapping")
public class AnnotationMappingServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>어노테이션매핑서블릿</title>");
		out.println("<meta charset='UTF-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>AnnotationMappingServlet[Dynamic Resource] 어노테이션매핑</p><hr>");
		out.println("web.xml대신에 annotation[@] 사용");
		out.println("</body>");
		out.println("</html>");
	}

}



















