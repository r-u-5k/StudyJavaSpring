package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 데이터베이스 설정 정보를 이용해서
 * Connection을 생성하고 해지(close)하는 역할을 하는 클래스
 * [Dao 객체들이 사용하는 클래스]
 */
public class DataSource {

	/******** 데이터베이스 접속 정보를 저장할 필드 ********/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
	String user = "jdeveloper43";
	String password = "jdeveloper43";
	/******************************************************/

	/*
	 * 데이터베이스 접속 정보를 이용하여 
	 * Connection 객체를 생성하여 반환하는 메서드
	 */
	public Connection getConnection() throws Exception {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	/*
	 * 사용한 Connection 객체를 닫는 메서드
	 */
	public void close(Connection con) throws Exception {
		con.close();
	}

}
