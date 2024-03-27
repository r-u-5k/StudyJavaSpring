package com.itwill.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
/* 모든 컨트롤러의 공통 예외를 처리 */
public class SpringGlobalCommonExceptionControllerAdvice {
	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e) {
		return "global_error_result";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handle_runtime_exception(RuntimeException e) {
		return "global_error_result";
	}
	
}
