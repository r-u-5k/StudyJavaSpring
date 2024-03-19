package com.itwill.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class IfTag extends TagSupport {
	private boolean test;
	
	public void setTest(boolean test) {
		System.out.println("2. setTest(" + test + ") 메서드 실행");
		this.test = test;
	}
	
	public IfTag() {
		System.out.println("1. IfTag 기본 생성자");
	}

	@Override
	public int doStartTag() throws JspException {
		if (test) {
			return TagSupport.EVAL_BODY_INCLUDE;
		} else {
			return TagSupport.SKIP_BODY;
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		return TagSupport.EVAL_PAGE; // 페이지 계속 실행
	}
}
