package com.itwill.jdbc.dao.board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	private DataSource dataSource;
	public BoardDao() {
		dataSource = new DataSource();
	}
	
	public int insert(Board board) throws Exception {
		String insertSql = "INSERT INTO BOARD(BOARD_NO, BOARD_TITLE, BOARD_CONTENT)"
				+ "VALUES(" + board.getBoard_no() + ", '" + board.getBoard_title() + "', '" + board.getBoard_content() + "')";
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);

		stmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int updateByBoardNo(Board board) throws Exception {
		String updateSql = "UPDATE BOARD SET BOARD_TITLE = '" + board.getBoard_title() + 
				"', BOARD_CONTENT = '" + board.getBoard_content() + "' WHERE BOARD_NO = 1";
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int deleteByBoardNo(int no) throws Exception {
		String deleteSql = "DELETE BOARD WHERE BOARD_NO = " + no;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public Board selectByBoardNo(int num) throws Exception {
		String selectSql = "SELECT * FROM BOARD WHERE BOARD_NO = " + num;
		Board findBoard = null;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		
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
		stmt.close();
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
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		
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
		stmt.close();
		dataSource.close(con);
		
		return boardList;
	}

}