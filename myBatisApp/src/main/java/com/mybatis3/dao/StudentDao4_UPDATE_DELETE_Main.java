package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDao4_UPDATE_DELETE_Main {

	public static void main(String[] args) {

		StudentDao studentDao = new StudentDao();

		/**************************************************
		 * UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		System.out.println("Update row count: " + studentDao.updateStudentById(
				Student.builder().name("수정").email("update@gmail.com").phone("000-000-0000").dob(new Date()).build()));
		/**************************************************
		 * DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("Delete row count: " + studentDao.deleteStudentById(24));

	}
}
