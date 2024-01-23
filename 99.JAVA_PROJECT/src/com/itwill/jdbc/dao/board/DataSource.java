package com.itwill.jdbc.dao.board;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	/******** 데이터베이스 접속 정보를 저장할 필드 ********/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
	String user = "jdeveloper43";
	String password = "jdeveloper43";
	/******************************************************/

	public Connection getConnection() throws Exception {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public void close(Connection con) throws Exception {
		con.close();
	}
}
