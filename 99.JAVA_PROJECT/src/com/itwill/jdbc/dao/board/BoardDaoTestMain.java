package com.itwill.jdbc.dao.board;

public class BoardDaoTestMain {

	public static void main(String[] args) throws Exception {
		BoardDao boardDao = new BoardDao();
		
		boardDao.insert(new Board(0, "제목", "내용", "SYSDATE", 0));
		
		boardDao.updateByBoardNo(new Board(3, "변경제목", "변경내용", "SYSDATE", 0));
		
		boardDao.deleteByBoardNo(8);
		
		boardDao.selectByBoardNo(5);
		
		boardDao.selectAll();
		
	}

}