package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatis implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.itwill.guest.mapper.GuestMapper.";
	
	public GuestDaoImplMyBatis() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public int insert(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount = sqlSession.insert(NAMESPACE + "insert", guest);
		sqlSession.close();
		return guest.getGuestNo();
	}

	@Override
	public int update(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int updateRowCount = sqlSession.update(NAMESPACE + "update", guest);
		sqlSession.close();
		return updateRowCount;
	}

	@Override
	public int delete(int guestNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE + "delete", guestNo);
		sqlSession.close();
		return deleteRowCount;
	}

	@Override
	public Guest findByGuestNo(int guestNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		Guest guest = guestMapper.findByGuestNo(guestNo);
		sqlSession.close();
		return guest;
	}

	@Override
	public List<Guest> findByAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		List<Guest> guestList = guestMapper.findByAll();
		sqlSession.close();
		return guestList;
	}

}
