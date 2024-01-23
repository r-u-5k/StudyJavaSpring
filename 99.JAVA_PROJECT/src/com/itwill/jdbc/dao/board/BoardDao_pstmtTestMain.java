package com.itwill.jdbc.dao.board;

public class BoardDao_pstmtTestMain {

	public static void main(String[] args) throws Exception {
		BoardDao_pstmt boardDao_pstmt = new BoardDao_pstmt();
		
		boardDao_pstmt.insert(new Board(0, "제목", "내용", "SYSDATE", 0));
		
		boardDao_pstmt.updateByBoardNo(new Board(3, "변경제목", "변경내용", "SYSDATE", 0));
		
		boardDao_pstmt.deleteByBoardNo(8);
		
		boardDao_pstmt.selectByBoardNo(5);
		
		boardDao_pstmt.selectAll();
		
	}

}