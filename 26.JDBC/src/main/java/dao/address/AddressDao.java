package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.common.DataSource;

public class AddressDao {
	/*
	 * DataSource 객체를 멤버 필드로 가짐
	 * (Connection을 생성/해제하는 객체)
	 */
	private DataSource dataSource;
	public AddressDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(Address address) throws Exception {
		String insertSql = "INSERT INTO ADDRESS VALUES(ADDRESS_NO_SEQ.NEXTVAL, '" 
							+ address.getName() + "', '" + address.getPhone() + "', '" + address.getAddress() +"')";
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);

		stmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int updateByNo(Address address) throws Exception {
		String updateSql = "UPDATE ADDRESS SET NAME = '" + address.getName() + "', PHONE = '" + address.getPhone() + "', "
							+ "ADDRESS = '" + address.getAddress() + "' WHERE NO = " + address.getNo();
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int deleteByNo(int no) throws Exception {
		String deleteSql = "DELETE FROM ADDRESS WHERE NO = " + no;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public Address selectByNo(int num) throws Exception {
		String selectSql = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS WHERE NO = " + num;
		Address findAddress = null;
		Connection con = dataSource.getConnection();
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
		dataSource.close(con);
		
		return findAddress;
	}
	
	public List<Address> selectAll() throws Exception {
		String selectSql = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS";
		List<Address> addressList = new ArrayList<>();
		Connection con = dataSource.getConnection();
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
		dataSource.close(con);
		
		return addressList;
	}
}
