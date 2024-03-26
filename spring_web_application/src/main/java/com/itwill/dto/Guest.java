package com.itwill.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder

public class Guest {
	private int guest_no;
	private String guest_name;
	private String guest_date;
	private String guest_email;
	private String guest_homepage;
	private String guest_title;
	private String guest_content;
}
