package com.mybatis3.basic;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentBasicMapper;
import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception {
		/*
		 * 0. mybatis-config-mapper-interface.xml --> InputStream
		 */
		InputStream myBatisConfigInputStream = 
				Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
		
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory = 
				sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		
		/*
		 * 3. SqlSession open (Connection)
		 * 	  autocommit true
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("SqlSession: " + sqlSession);
		
		/*
		 * 4. StudentBasicMapper[MapperInterface]생성
		 *    org.apache.ibatis.binding.MapperProxy
		 */
		StudentBasicMapper studentBasicMapper = sqlSession.getMapper(StudentBasicMapper.class);
		System.out.println("StudentBasicMapper: " + studentBasicMapper);
		
		/*
		 * 4. StudentBasicMapper[MapperInterface]사용(CRUD)
		 */
		System.out.println("Student List: " + studentBasicMapper.findAllStudents());
		System.out.println("Student: " + studentBasicMapper.findStudentById(1));
		
		/*
		 * 5. SqlSession close
		 */
		sqlSession.close();
		
	}
}
