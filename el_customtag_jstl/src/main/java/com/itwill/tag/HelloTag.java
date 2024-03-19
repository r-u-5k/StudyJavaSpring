package com.itwill.tag;

import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	
	public HelloTag() {
		System.out.println("1. HelloTag 기본 생성자");
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		HttpSession session = pageContext.getSession();
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId == null) {
			sUserId = "Guest";
		}
		try {
			out.print(sUserId + "님 안녕하세요.<br>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print("<hr>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	
}
