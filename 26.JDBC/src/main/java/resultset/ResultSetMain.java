package resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import dao.common.DataSource;

public class ResultSetMain {
	/*
	이름         널?       유형            
	---------- -------- ------------- 
	NO         NOT NULL NUMBER(7)     
	NAME                VARCHAR2(50)  
	SHORT_DESC          VARCHAR2(255) 
	PRICE               NUMBER(10,3)  
	IPGO_DATE           DATE          
	*/
	public static void main(String[] args) throws Exception {
		String selectSQL = "SELECT NO, NAME, SHORT_DESC, PRICE, IPGO_DATE FROM PRODUCT";
		Connection con = new DataSource().getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSQL);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("- ResultSet.get타입(컬럼이름) -");
		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String shortDesc = rs.getString("SHORT_DESC");
			double price = rs.getDouble("PRICE");
			Date ipgoDate = rs.getDate("IPGO_DATE");
			System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();
		
		System.out.println("\n- ResultSet.get타입(컬럼인덱스[1, 2, ~]) -");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt(1);
			String name = rs.getString(2);
			String shortDesc = rs.getString(3);
			double price = rs.getDouble(4);
			Date ipgoDate = rs.getDate(5);
			System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();
		
		System.out.println("\n- ResultSet.getString(컬럼이름) -");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String no = rs.getString(1);
			String name = rs.getString(2);
			String shortDesc = rs.getString(3);
			String price = rs.getString(4);
			String ipgoDate = rs.getString(5);
			System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();
		
		System.out.println("\n- ResultSet.getObject(컬럼이름) -");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Object no = rs.getObject(1);
			Object name = rs.getObject(2);
			Object shortDesc = rs.getObject(3);
			Object price = rs.getObject(4);
			Object ipgoDate = rs.getObject(5);
			System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();
	}

}
