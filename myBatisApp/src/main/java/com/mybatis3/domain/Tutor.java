package com.mybatis3.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Tutor {
	private Integer tutorId;
	private String name;
	private String email;
	private Date dob;
	private Address address; // FK
	@Default
	private List<Course> courseList = new ArrayList<Course>();
}
