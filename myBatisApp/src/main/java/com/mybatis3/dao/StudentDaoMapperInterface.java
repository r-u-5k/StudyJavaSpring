package com.mybatis3.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class StudentDaoMapperInterface {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.mybatis3.dao.mapper.StudentMapper.";

	public StudentDaoMapperInterface() {
		try {
			InputStream mybatisConfigInputStream = Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**************************************************
	1. SELECT[결과타입이 DTO[DTO List] 객체인경우] 
	**************************************************/
	/*
	 resultType Dto 
	*/
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Student student = sqlSession.getMapper(StudentMapper.class).findStudentById(studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = studentMapper.findAllStudents();
		sqlSession.close();
		return studentList;
	}

}
