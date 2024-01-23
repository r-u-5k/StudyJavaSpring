package com.itwill.jdbc.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao_pstmt {
	private DataSource dataSource;
	public BoardDao_pstmt() {
		dataSource = new DataSource();
	}
	
	public int insert(Board board) throws Exception {
		String insertSql = "INSERT INTO BOARD(BOARD_NO, BOARD_TITLE, BOARD_CONTENT) VALUES(?, ?, ?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(insertSql);
		pstmt1.setInt(1, board.getBoard_no());
		pstmt1.setString(2, board.getBoard_title());
		pstmt1.setString(3, board.getBoard_content());
		int rowCount = pstmt1.executeUpdate(insertSql);

		pstmt1.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int updateByBoardNo(Board board) throws Exception {
		String updateSql = "UPDATE BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BOARD_NO = ?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt2 = con.prepareStatement(updateSql);
		pstmt2.setString(1, board.getBoard_title());
		pstmt2.setString(2, board.getBoard_content());
		pstmt2.setInt(3, board.getBoard_no());
		int rowCount = pstmt2.executeUpdate(updateSql);
		
		pstmt2.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int deleteByBoardNo(int no) throws Exception {
		String deleteSql = "DELETE BOARD WHERE BOARD_NO = ?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt3 = con.prepareStatement(deleteSql);
		pstmt3.setInt(1, no);
		int rowCount = pstmt3.executeUpdate(deleteSql);
		
		pstmt3.close();
		dataSource.close(con);
		return rowCount;
	}

	public Board selectByBoardNo(int no) throws Exception {
		String selectSql = "SELECT * FROM BOARD WHERE BOARD_NO = ?";
		Board findBoard = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt4 = con.prepareStatement(selectSql);
		pstmt4.setInt(1, no);
		ResultSet rs = pstmt4.executeQuery(selectSql);
		
		if (rs.next()) {
			int board_no = rs.getInt("BOARD_NO");
			String board_title = rs.getString("BOARD_TITLE");
			String board_content = rs.getString("BOARD_CONTENT");
			String board_wday = rs.getString("BOARD_WDAY");
			int board_read_count = rs.getInt("BOARD_READ_COUNT");
			findBoard = new Board(board_no, board_title, board_content, board_wday, board_read_count);
		} else {
			findBoard = null;
		}
		
		rs.close();
		pstmt4.close();
		dataSource.close(con);
		
		return findBoard;
	}
	
	public List<Board> selectAll() throws Exception {
		/*
		 * (X) rs.getDate("board_wday");
		 * (O) rs.getString("board_wday");
		 */
		String selectSql = "SELECT * FROM BOARD";
		List<Board> boardList = new ArrayList<>();
		Board findBoard = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt5 = con.prepareStatement(selectSql);
		ResultSet rs = pstmt5.executeQuery(selectSql);
		
		if (rs.next()) {
			do {
				int board_no = rs.getInt("BOARD_NO");
				String board_title = rs.getString("BOARD_TITLE");
				String board_content = rs.getString("BOARD_CONTENT");
				String board_wday = rs.getString("BOARD_WDAY");
				int board_read_count = rs.getInt("BOARD_READ_COUNT");
				findBoard = new Board(board_no, board_title, board_content, board_wday, board_read_count);
				boardList.add(findBoard);
			} while (rs.next());
		}
		
		rs.close();
		pstmt5.close();
		dataSource.close(con);
		
		return boardList;
	}

}