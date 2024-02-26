package com.mybatis3.basic;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class MyBatisFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0. mybatis-config.xml --> InputStream
		 */
		InputStream myBatisConfigStream = Resources.getResourceAsStream("mybatis-config.xml");
		
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigStream);
		
		/*
		 * 3. SqlSession open (Connection) & autocommit true
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println(sqlSession);
		
		/*
		 * 4. SqlSession사용(CRUD)
		*/
		List<Student> studentList = sqlSession.selectList("com.mybatis3.dao.mapper.StudentBasicMapper.findAllStudents");
		System.out.println("StudentList: " + studentList);
		Student student = sqlSession.selectOne("com.mybatis3.dao.mapper.StudentBasicMapper.findStudentById", 6);
		System.out.println("Student: " + student);
		
		/*
		 * 5. SqlSession close
		 */
		sqlSession.close();
		
	}
}

