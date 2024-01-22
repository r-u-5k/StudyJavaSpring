package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableDeleteByNoMain {
	
	public static void main(String[] args) throws Exception {
		/*************** 데이터베이스 접속 정보 ***************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper43";
		String password = "jdeveloper43";
		/******************************************************/
		String deleteSql = "DELETE FROM ADDRESS WHERE NO = 1";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> Delete Row Count: " + rowCount);
		
		stmt.close();
		con.close();
	}
}
