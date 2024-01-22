package dao.address.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDao2 {
	/*
	 * 데이터베이스 접속 정보를 이용하여 
	 * Connection 객체를 생성하여 반환하는 메서드
	 */
	public Connection getConnection() throws Exception {
		/*************** 데이터베이스 접속 정보 ***************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper43";
		String password = "jdeveloper43";
		/******************************************************/
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	public void insert() throws Exception {
		
		String insertSql = "INSERT INTO ADDRESS VALUES(ADDRESS_NO_SEQ.NEXTVAL, '김경호', '123-4567', '서울시여러분')";
		Connection con = null;
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> Insert Row Count: " + rowCount);

		stmt.close();
		con.close();
	}
	
	public void updateByNo() throws Exception {
		
		String updateSql = "UPDATE ADDRESS SET NAME = '김변경', PHONE = '888-8888', ADDRESS = '부산시여러분' WHERE NO = 1";
		Connection con = null;
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> Update Row Count: " + rowCount);
		
		stmt.close();
		con.close();
	}
	
	public void deleteByNo() throws Exception {
		
		String deleteSql = "DELETE FROM ADDRESS WHERE NO = 1";
		Connection con = null;
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> Delete Row Count: " + rowCount);
		
		stmt.close();
		con.close();
	}

	public void selectByNo() throws Exception {
		
		String selectSql = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS WHERE NO = 3";
		Connection con = null;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		
		if (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String phone = rs.getString("PHONE");
			String address = rs.getString("ADDRESS");
			System.out.println(no + "\t" + name + "\t" + phone + "\t" + address + "\t");
		} else {
			System.out.println("그런 사람 없습니다");
		}
		
		stmt.close();
		con.close();
	}
	
	public void selectAll() throws Exception {
		
		String selectSql = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS";
		Connection con = null;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		
		if (rs.next()) {
			do {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				System.out.println(no + "\t" + name + "\t" + phone + "\t" + address + "\t");
			} while (rs.next());
		}
		stmt.close();
		con.close();
	}
}
