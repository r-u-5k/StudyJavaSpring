package com.mybatis3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder.Default;

/*
이름      널?       유형           
------- -------- ------------ 
ADDR_ID NOT NULL NUMBER(11)   
STREET  NOT NULL VARCHAR2(50) 
CITY    NOT NULL VARCHAR2(50) 
STATE   NOT NULL VARCHAR2(50) 
ZIP              VARCHAR2(10) 
COUNTRY NOT NULL VARCHAR2(50)
*/
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Address implements Serializable {
	private Integer addrId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	@Default
	private List<Student> studentList = new ArrayList<Student>();

}
