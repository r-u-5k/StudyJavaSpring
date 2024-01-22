package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressTableSelectAllMain {

	public static void main(String[] args) throws Exception {
		/*************** 데이터베이스 접속 정보 ***************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper43";
		String password = "jdeveloper43";
		/******************************************************/
		String selectSql = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		/*
		이름      널?       유형           
		------- -------- ------------ 
		NO      NOT NULL NUMBER(10)   
		NAME             VARCHAR2(50) 
		PHONE   NOT NULL VARCHAR2(50) 
		ADDRESS          VARCHAR2(50)
		*/
		/* --------------------------------
		 * DB타입 		| 자바타입
		 * --------------------------------
		 * number		| int,double(float)
		 * varchar2,char| String
		 * Date			| Date
		 * --------------------------------
		 */
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
