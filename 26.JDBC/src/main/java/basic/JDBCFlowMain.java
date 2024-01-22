package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception {
		/*************** 데이터베이스 접속 정보 ***************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper13";
		String password = "jdeveloper13";

		String selectSql = "SELECT DEPTNO, DNAME, LOC FROM DEPT";

		/*
		 * 1. Driver class loading
		 */
		Class.forName(driverClass);
		System.out.println("1. Driver Class Loading");

		/*
		 * 2. Connection 객체 생성
		 */
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. Connection 객체 생성: " + con);

		/*
		 * 3. Statement 객체 생성 - SQL문 전송 객체
		 */
		Statement stmt = con.createStatement();
		System.out.println("3. Statement 객체 생성: " + stmt);

		/*
		 * 4. SQL문 전송(select) 5. Result Set (RS) 반환
		 */
		ResultSet rs = stmt.executeQuery(selectSql);
		System.out.println("4. SQL문 전송");
		System.out.println("5. ResultSet 객체 얻기: " + rs);

		while (rs.next()) {
			int deptno = rs.getInt("DEPTNO");
			String dname = rs.getString("DNAME");
			String loc = rs.getString("LOC");
			System.out.println(deptno + "\t" + dname + "\t" + loc);
		}
		
		/*
		 * 6. 연결 객체 (리소스) Close
		 */
		System.out.println("6. 연결 객체 (리소스) Close");
		rs.close();
		stmt.close();
		con.close();

	}

}
