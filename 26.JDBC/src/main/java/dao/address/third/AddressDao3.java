package dao.address.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDao3 {
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
	
	
	public int insert(Address address) throws Exception {
		String insertSql = "INSERT INTO ADDRESS VALUES(ADDRESS_NO_SEQ.NEXTVAL, '" 
							+ address.getName() + "', '" + address.getPhone() + "', '" + address.getAddress() +"')";
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);

		stmt.close();
		close(con);
		return rowCount;
	}
	
	public int updateByNo(Address address) throws Exception {
		String updateSql = "UPDATE ADDRESS SET NAME = '" + address.getName() + "', PHONE = '" + address.getPhone() + "', "
							+ "ADDRESS = '" + address.getAddress() + "' WHERE NO = " + address.getNo();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		
		stmt.close();
		close(con);
		return rowCount;
	}
	
	public int deleteByNo(int no) throws Exception {
		String deleteSql = "DELETE FROM ADDRESS WHERE NO = " + no;
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		
		stmt.close();
		close(con);
		return rowCount;
	}

	public Address selectByNo(int num) throws Exception {
		String selectSql = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS WHERE NO = " + num;
		Address findAddress = null;
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		
		if (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String phone = rs.getString("PHONE");
			String address = rs.getString("ADDRESS");
			findAddress = new Address(no, name, phone, address);
		} else {
			findAddress = null;
		}
		
		rs.close();
		stmt.close();
		close(con);
		
		return findAddress;
	}
	
	public List<Address> selectAll() throws Exception {
		String selectSql = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS";
		List<Address> addressList = new ArrayList<>();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		
		if (rs.next()) {
			do {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String addr = rs.getString("ADDRESS");
				Address address = new Address(no, name, phone, addr);
				addressList.add(address);
			} while (rs.next());
		}
		
		rs.close();
		stmt.close();
		close(con);
		
		return addressList;
	}
}
