package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class StatementMain {

	public static void main(String[] args) throws Exception {
		/*************** 데이터베이스 접속 정보 ***************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper13";
		String password = "jdeveloper13";
		/******************************************************/
		/*
		이름       널?       유형           
		-------- -------- ------------ 
		EMPNO    NOT NULL NUMBER(4)    
		ENAME             VARCHAR2(10) 
		JOB               VARCHAR2(9)  
		MGR               NUMBER(4)    
		HIREDATE          DATE         
		SAL               NUMBER(7,2)  
		COMM              NUMBER(7,2)  
		DEPTNO            NUMBER(2)    
		*/
		
		String selectSql = "SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP WHERE SAL >= 1000 AND SAL <= 4000 AND JOB = 'SALESMAN' OR JOB = 'CLERK'";
		String insertSql = "INSERT INTO EMP VALUES(9000, 'JUNG', 'MANAGER', 7369, TO_DATE('2000/01/10', 'YYYY/MM/DD'), 3000.34, 30, 40)";
		String updateSql = "UPDATE EMP SET SAL = SAL * 1.3 WHERE EMPNO >= 7369 AND EMPNO <= 7600";
		String deleteSql = "DELETE FROM EMP WHERE EMPNO = 9000";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		System.out.println("--- Statement.executeQuery(selectSql) ---");
		ResultSet rs = stmt.executeQuery(selectSql);
		while (rs.next()) {
			int empno = rs.getInt("EMPNO");
			String ename = rs.getString("ENAME");
			String job = rs.getString("JOB");
			double sal = rs.getDouble("SAL");
			Date hireDate = rs.getDate("HIREDATE");
			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal + "\t" + hireDate);
		}
		rs.close();
		
		System.out.println("----- Statement.executeUpdate(dml) -----");
		
		int rowCount = 0;
		rowCount = stmt.executeUpdate(insertSql);
		System.out.println("Insert Row Count: " + rowCount);
		rowCount = stmt.executeUpdate(updateSql);
		System.out.println("Update Row Count: " + rowCount);
		rowCount = stmt.executeUpdate(deleteSql);
		System.out.println("Delete Row Count: " + rowCount);
		
		stmt.close();
		con.close();
		
	}

}
