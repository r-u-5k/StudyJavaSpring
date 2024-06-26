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

/*
이름          널?       유형            
----------- -------- ------------- 
COURSE_ID   NOT NULL NUMBER(11)    
NAME        NOT NULL VARCHAR2(100) 
DESCRIPTION          VARCHAR2(512) 
START_DATE           DATE          
END_DATE             DATE          
TUTOR_ID    NOT NULL NUMBER(11)    	
*/

public class Course {
	private Integer courseId;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Tutor tutor; // FK
	@Default
	private List<Student> studentList = new ArrayList<Student>();
}
