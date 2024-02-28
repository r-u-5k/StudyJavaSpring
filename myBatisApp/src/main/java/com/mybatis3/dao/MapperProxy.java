package com.mybatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis3.dao.mapper.StudentBasicMapper;
import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MapperProxy /* implements StudentBasicMapper */ {
	private SqlSession sqlSession;

	//@Override
	public Student findStudentById(Integer studId) {
		String namespace = StudentBasicMapper.class.getName();
		Student student = sqlSession.selectOne(namespace + ".findStudentById", studId);
		sqlSession.commit();
		sqlSession.close();
		return student;
	}

	//@Override
	public List<Student> findAllStudents() {
		String namespace = StudentBasicMapper.class.getName();
		sqlSession.selectList(namespace + ".findAllStudents");
		return null;
	}

}
