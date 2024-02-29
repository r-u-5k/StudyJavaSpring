package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와 일치
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와 일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType과 일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType과 일치(ResultSet이 1개 이상일 경우는 List)
	 */
	/**************************************************
	 * 1. SELECT[결과타입이 DTO[DTO List] 객체인경우]
	 **************************************************/
	@ResultType(Student.class)
	@Select("SELECT STUD_ID, NAME, EMAIL, PHONE, DOB FROM STUDENTS WHERE STUD_ID = #{STUDID}")
	public Student findStudentById(@Param("STUDID") Integer studId);

	@ResultType(Student.class)
	@Select("SELECT STUD_ID, NAME, EMAIL, PHONE, DOB FROM STUDENTS")
	public List<Student> findAllStudents();

	/*
	<select id="findStudentById" parameterType="int" resultType="com.mybatis3.domain.Student">
		select stud_id,name,phone,email,dob from students where stud_id=#{studId}
	</select>
	<select id="findAllStudents" resultType="com.mybatis3.domain.Student">
		select stud_id,name,phone,email,dob from students
	</select>
	 */
	/*******************************************************************
	 * 2. SELECT[결과타입이 Wrapper(String)[Wrapper(String) List]객체인경우]
	 *******************************************************************/
	@Results({
		@Result(column = "STUD_ID", property = "studId", id = true),
		@Result(column = "NAME", 	property = "name"),
		@Result(column = "EMAIL", 	property = "email"),
		@Result(column = "PHONE", 	property = "phone"),
		@Result(column = "DOB", 	property = "dob"),
		@Result(column = "ADDR_ID", property = "address", 
				one = @One(select = "com.mybatis3.dao.mapper.AddressMapper.findAddressById"))
	})
	@Select("SELECT STUD_ID, NAME, EMAIL, PHONE, DOB FROM STUDENTS WHERE STUD_ID = #{studId}")
	public Student findStudentByIdResultMap(@Param("studId") Integer studId);
	
	@ResultMap("studentResultMap")
	@Select("SELECT STUD_ID, NAME, EMAIL, PHONE, DOB FROM STUDENTS")
	public List<Student> findAllStudentsResultMap();
	
	/*
	<select id="findStudentByIdResultMap" parameterType="int" resultMap="studentResultMap">
		select stud_id,name,phone,email,dob from students where stud_id=#{studId}
	</select>
	<select id="findAllStudentsResultMap" resultMap="studentResultMap">
		select stud_id,name,phone,email,dob from students
	</select>
	 */
	/**************************************************
	 * 3. SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	
	@ResultMap("studentResultMap")
	@Select("SELECT STUD_ID, NAME, EMAIL, DOB, A.ADDR_ID, STREET, CITY, STATE, ZIP, COUNTRY\r\n"
			+ "  		FROM STUDENTS S\r\n"
			+ " 		LEFT OUTER JOIN ADDRESSES A ON S.ADDR_ID = A.ADDR_ID\r\n"
			+ " 		WHERE STUD_ID = #{STUDID}")
	
	/* 이렇게 해도 됨
	@Results({
		@Result(column = "STUD_ID", property = "studId", id = true),
		@Result(column = "NAME", 	property = "name"),
		@Result(column = "EMAIL", 	property = "email"),
		@Result(column = "PHONE", 	property = "phone"),
		@Result(column = "DOB", 	property = "dob"),
		@Result(column = "ADDR_ID", property = "address", 
				one = @One(select = "com.mybatis3.dao.mapper.AddressMapper.findAddressById"))
	})
	@Select("SELECT * FROM STUDENTS WHERE STUD_ID = #{studId}")
	*/
	Student findStudentByIdWithAddress(Integer studId);
	
	/*********************************************************
	 * 4. SELECT[students + course_enrollment(+ courses)] JOIN( 1 : N )
	 ********************************************************/
	Student findStudentByIdWithCourses(Integer studId);

	/**************************************************
	 * 5. SELECT[students + address + courses[course_enrollment] JOIN( 1 : 1 : N )
	 **************************************************/
	Student findStudentByIdWithAddressAndCourses(Integer studId);

	/**************************************************
	 * INSERT
	 ***************************************************/
	@Insert("INSERT INTO STUDENTS (STUD_ID, NAME, PHONE, EMAIL, DOB) VALUES (STUDENTS_STUD_ID_SEQ.NEXTVAL, #{name}, #{phone}, #{email}, #{dob})")
	int insertStudentBySequence(Student student);
	
	@SelectKey(before = true, resultType = Integer.class, keyProperty = "studId", statement = "SELECT STUDENTS_STUD_ID_SEQ.NEXTVAL FROM DUAL")
	@Insert("INSERT INTO STUDENTS (STUD_ID, NAME, PHONE, EMAIL, DOB) VALUES (#{studId}, #{name}, #{phone}, #{email}, #{dob})")
	int insertStudentBySequenceReturnPrimaryKey(Student student);
	
	/**************************************************
	 * UPDATE
	 ***************************************************/
	int updateStudentById(Student updateStudent);

	/**************************************************
	 * DELETE
	 ***************************************************/
	int deleteStudentById(Integer studId);
	int deleteStudentByName(String name);
	int deleteStudentByNameLike(String name);

}
