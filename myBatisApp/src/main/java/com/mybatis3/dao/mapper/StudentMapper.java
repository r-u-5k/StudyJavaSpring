package com.mybatis3.dao.mapper;

import java.util.List;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와 일치
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와 일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType과 일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType과 일치(ResultSet이 1개 이상일 경우는 List)
	 */
	public Student findStudentById(Integer studId);
	public List<Student> findAllStudents();
	
	/**************************************************
	1. SELECT[결과타입이 DTO[DTO List] 객체인경우] 
	**************************************************/
	/*
	<select id="findStudentById" parameterType="int" resultType="com.mybatis3.domain.Student">
		select stud_id,name,phone,email,dob from students where stud_id=#{studId}
	</select>
	<select id="findAllStudents" resultType="com.mybatis3.domain.Student">
		select stud_id,name,phone,email,dob from students
	</select>
	 */
}
