package com.itwill.jdbc.dao.board;

public class BoardDaoTestMain {

	public static void main(String[] args) throws Exception {
		BoardDao boardDao = new BoardDao();
		
		boardDao.deleteByBoardNo(0);
		
		boardDao.insert(new Board(0, "제목", "내용", "SYSDATE", 0));
		
		boardDao.updateByBoardNo(new Board(5, "변경제목", "변경내용", "SYSDATE", 0));
		
		boardDao.selectByBoardNo(5);
		
		boardDao.selectAll();
		
	}

}