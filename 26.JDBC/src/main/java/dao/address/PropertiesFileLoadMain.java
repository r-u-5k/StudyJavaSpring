package dao.address;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileLoadMain {

	public static void main(String[] args) throws Exception {
		/*
		 * .properties 설정 파일을 읽어서 Properties[Map] 객체 생성
		 */
		Properties properties = new Properties();
		/*
		 * << 절대경로 >>
		FileInputStream fis = new FileInputStream("C:\\2023-12-JAVA-DEVELOPER\\spring-workspace\\26.JDBC\\src\\main\\java\\a.properties");
		*/
		
		/*
		 * << 상대경로 >>
		 */
		InputStream fis = PropertiesFileLoadMain.class.getResourceAsStream("/a.properties");
		properties.load(fis);
		
		/*
		<<Properties객체>>
		------------------------------------------------------
		 key(String)| value(String)
		------------------------------------------------------
		driverClass |oracle.jdbc.OracleDriver
		url         |jdbc:oracle:thin:@124.198.47.195:1521:xe
		user        |jdeveloper43
		password    |jdeveloper43
		-------------------------------------------------------
		*/
		
		String driverClass = (String) properties.get("driverClass");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
	}

}
