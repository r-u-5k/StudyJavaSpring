package dao.address.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressDao2 {
	/*
	 * 데이터베이스 접속 정보를 이용하여 
	 * Connection 객체를 생성하여 반환하는 메서드
	 */
	private Connection getConnection() throws Exception {
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
	
	/*
	 * 사용한 Connection 객체를 닫는 메서드
	 */
	private void close(Connection con) throws Exception {
		con.close();
	}
	
	public void insert(String name, String phone, String address) throws Exception {
		String insertSql = "INSERT INTO ADDRESS VALUES(ADDRESS_NO_SEQ.NEXTVAL, '" 
							+ name + "', '" + phone + "', '" + address +"')";
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> Insert Row Count: " + rowCount);

		stmt.close();
		close(con);
	}
	
	public void updateByNo(int no, String name, String phone, String address) throws Exception {
		String updateSql = "UPDATE ADDRESS SET NAME = '" + name + "', PHONE = '" + phone + "', ADDRESS = '" + address + "' WHERE NO = " + no;
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> Update Row Count: " + rowCount);
		
		stmt.close();
		close(con);
	}
	
	public void deleteByNo(int no) throws Exception {
		String deleteSql = "DELETE FROM ADDRESS WHERE NO = " + no;
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> Delete Row Count: " + rowCount);
		
		stmt.close();
		close(con);
	}

	public void selectByNo(int num) throws Exception {
		String selectSql = "SELECT " + num + ", NAME, PHONE, ADDRESS FROM ADDRESS WHERE NO = 3";
		Connection con = getConnection();
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
		close(con);
	}
	
	public void selectAll() throws Exception {
		String selectSql = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS";
		Connection con = getConnection();
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
		close(con);
	}
}
