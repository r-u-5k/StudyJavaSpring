package com.itwill.ajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ajax.domain.News;

@RestController
public class JavaScriptAjaxRestController {
	/*
	 << @ResponseBody >> 
	  - ViewResolver --> View를 사용하지 않는다 
	  - MessageConverter(text,xml,json)가 변경한데이타를 
	    	HttpResponse객체가 클라이언트로 응답한다. 
	  - @RestController 어노테이션을 사용하면
	    생략가능하다.
	 */
	
	@GetMapping(value = "/01.ajaxRequestGET/{id}", produces = "text/plain;charset=UTF-8")
	public String ajaxRequestGET(@PathVariable(name = "id") String id) {
		String msg = "";
		if (id.startsWith("guard")) {
			msg = "가드";
		} else {
			msg = "사용 가능한 아이디";
		}
		return msg;
	}
	
	private List<News> getNewsList() {
		List<News> newsList = new ArrayList<News>();
		newsList.add(new News(1, "김순옥vs남궁민, 빅매치 성사…'연인'파트2, '소옆경' 이어 '7인의 탈출'도 꺾을까?", "MD포커스", new Date().toLocaleString()));
		newsList.add(new News(2, "MBC가 금토드라마 '연인' 파트2를 10월 13일 방송 편성 확정했다고 13일 공식 발표했다.", "MBC뉴스", new Date().toLocaleString()));
		newsList.add(new News(3, "BTS 정국 \"헬스장 오고 배달음식 보내는 팬 有…부적절한 말 무시도 내 선택\"", "종합", new Date().toLocaleString()));
		newsList.add(new News(4, "방탄소년단 정국이 사생 피해를 고백하며 아미와의 적절한 관계를 유지하는 법을 공개했다.", "TBC뉴스", new Date().toLocaleString()));
		newsList.add(new News(5, "폭행 피해자 3명에 사과?…김히어라 측 고소장 준비 중, 추가입장 無", "OMY뉴스", new Date().toLocaleString()));
		newsList.add(new News(6, "'현빈♥' 손예진, 2년만 공개 골프나들이 \"결혼도 하고, 아이도 낳고\" ", "조선뉴스", new Date().toLocaleString()));
		newsList.add(new News(7, "배우 손예진(본명 손언진·41)이 2년 만의 공개 골프 나들이를 예고했다.", "YTN뉴스", new Date().toLocaleString()));
		newsList.add(new News(8, "남태현·서민재 필로폰 투약 혐의 10월 19일 첫 공판", "CBS뉴스", new Date().toLocaleString()));
		newsList.add(new News(9, "'소년판타지' 제작사, '팀 이탈' 유준원에 30억 손배소", "ITWILL뉴스", new Date().toLocaleString()));
		return newsList;
	}

	private String[] keywords = { "AJAX", "AJAX 실전 프로그래밍", "AJA", "AZERA", "자라자", "자라", "자바 프로그래밍", "자바 서버 페이지",
			"자바스터디", "자바서비스", "자바캔" };

	public List<String> search(String keyword) {
		if (keyword == null || keyword.equals(""))
			return new ArrayList<String>();

		keyword = keyword.toUpperCase();

		List<String> result = new ArrayList<String>();

		for (int i = 0; i < keywords.length; i++) {
			if (((String) keywords[i]).startsWith(keyword)) {
				result.add(keywords[i]);
			}
		}
		return result;
	}

}
