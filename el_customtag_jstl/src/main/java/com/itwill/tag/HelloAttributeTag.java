package com.itwill.tag;

import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class HelloAttributeTag extends TagSupport {
	private String name;
	
	public void setName(String name) {
		System.out.printf("2. setName(%s) 메서드 호출\n", name);
		this.name = name;
	}

	public HelloAttributeTag() {
		System.out.println("1. HelloAttributeTag 기본 생성자");
	}
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("3. doStartTag() 메서드 호출");
		String msg = "";
		if (name.equals("김경호")) {
			msg = "강사님 안녕하세요.";
		} else {
			msg = name + "님 안녕하세요.";
		}
		JspWriter out = pageContext.getOut();
		try {
			out.print(msg + "<br>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("4. doEndTag() 메서드 호출");
		try {
			pageContext.getOut().print("<hr>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	
}
