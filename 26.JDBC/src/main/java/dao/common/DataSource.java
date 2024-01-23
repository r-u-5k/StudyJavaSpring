package dao.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * 데이터베이스 설정 정보를 이용해서
 * Connection을 생성하고 해지(close)하는 역할을 하는 클래스
 * [Dao 객체들이 사용하는 클래스]
 */
public class DataSource {
	public DataSource() throws Exception {
		/* jdbc.properties 파일을 읽어서 데이터베이스 접속 정보를 얻음 */
		Properties properties = new Properties();
		/*
		 * jdbc.properties 파일은 src/main/java 폴더에 위치해야 함
		 */
		InputStream in = DataSource.class.getResourceAsStream("/jdbc.properties");
		properties.load(in);
		this.driverClass = properties.getProperty("driverClass");
		this.url = properties.getProperty("url");
		this.user = properties.getProperty("user");
		this.password = properties.getProperty("password");
		
	}
	/******** 데이터베이스 접속 정보를 저장할 필드 ********/
	private String driverClass;
	private String url;
	private String user;
	private String password;
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
