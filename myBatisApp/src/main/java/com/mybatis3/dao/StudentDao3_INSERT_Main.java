package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDao3_INSERT_Main {

	public static void main(String[] args) {

		StudentDao studentDao = new StudentDao();
		/**************************************************
		 * INSERT
		 ***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudentBySequence(Dto)--------------------------");
		int insertRowCount = studentDao.insertStudentBySequence(
				Student.builder().name("SEQ1").phone("123-456-7890").email("kim1@gmail.com").dob(new Date()).build());
		System.out.println(">>> Dao return insertRowCount:" + insertRowCount);
		
		System.out.println("---------insertStudentBySequenceReturnPrimaryKey---------------");
		Student insertStudent = Student.builder().name("SEQ2").phone("222-333-4444").email("kim2@gmail.com").dob(new Date()).build();
		insertRowCount = studentDao.insertStudentBySequenceReturnPrimaryKey(insertStudent);
		System.out.println(">>> insertRowCount: " + insertRowCount);
		System.out.println(">>> Student[Dto] primary key: " + insertStudent.getStudId());

	}
}
