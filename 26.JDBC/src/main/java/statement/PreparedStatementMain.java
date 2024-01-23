package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class PreparedStatementMain {

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
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		
		System.out.println(" ------------- SELECT -------------");
		String selectSql = "SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP WHERE SAL >= ? AND SAL <= ? AND JOB = ? OR JOB = ?";
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		
		int sal1 = 1000;
		int sal2 = 4000;
		String job1 = "SALESMAN";
		String job2 = "CLERK";
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int empno = rs.getInt("EMPNO");
			String ename = rs.getString("ENAME");
			String job = rs.getString("JOB");
			double sal = rs.getDouble("SAL");
			Date hireDate = rs.getDate("HIREDATE");
			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal + "\t" + hireDate);
		}
		rs.close();
		pstmt.close();
		
		System.out.println(" ------------- DELETE -------------");
		String deleteSql = "DELETE FROM EMP WHERE EMPNO = ?";
		PreparedStatement pstmt5 = con.prepareStatement(deleteSql);
		pstmt5.setInt(1, 9001);
		int rowCount5 = pstmt5.executeUpdate();
		System.out.println(">> Delete 9001 -> " + rowCount5 + "행 삭제");
		
		pstmt5.setInt(1, 9002);
		rowCount5 = pstmt5.executeUpdate();
		System.out.println(">> Delete 9002 -> " + rowCount5 + "행 삭제");
		
		pstmt5.setInt(1, 9003);
		rowCount5 = pstmt5.executeUpdate();
		System.out.println(">> Delete 9003 -> " + rowCount5 + "행 삭제");
		
		pstmt5.setInt(1, 9004);
		rowCount5 = pstmt5.executeUpdate();
		System.out.println(">> Delete 9004 -> " + rowCount5 + "행 삭제");
		
		pstmt5.close();
		
		System.out.println(" ------------- INSERT -------------");
		String insertSql1 = "INSERT INTO EMP VALUES(?, ?, ?, ?, TO_DATE(?, ?), ?, ?, ?)";
		PreparedStatement pstmt1 = con.prepareStatement(insertSql1);
		pstmt1.setInt(1, 9001);
		pstmt1.setString(2, "심윤보");
		pstmt1.setString(3, "MANAGER");
		pstmt1.setInt(4, 7369);
		pstmt1.setString(5, "2020/08/08");
		pstmt1.setString(6, "YYYY/MM/DD");
		pstmt1.setDouble(7, 5900.9898);
		pstmt1.setInt(8, 60);
		pstmt1.setInt(9, 40);
		int rowCount1 = pstmt1.executeUpdate();
		System.out.println(">> Insert 9001 -> " + rowCount1 + "행 Insert");
		pstmt1.close();
		
		String insertSql2 = "INSERT INTO EMP VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";
		PreparedStatement pstmt2 = con.prepareStatement(insertSql2);
		pstmt2.setInt(1, 9002);
		pstmt2.setString(2, "김태희");
		pstmt2.setString(3, "CLERK");
		pstmt2.setInt(4, 7369);
		pstmt2.setDouble(5, 5656.32);
		pstmt2.setInt(6, 33);
		pstmt2.setInt(7, 40);
		int rowCount2 = pstmt2.executeUpdate();
		System.out.println(">> Insert 9002 -> " + rowCount2 + "행 Insert");
		pstmt2.close();
		
		String insertSql3 = "INSERT INTO EMP VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt3 = con.prepareStatement(insertSql3);
		pstmt3.setInt(1, 9003);
		pstmt3.setString(2, "DIM");
		pstmt3.setString(3, "SALESMAN");
		pstmt3.setInt(4, 7369);
		java.util.Date utilDate = new SimpleDateFormat("yyyy/MM/dd").parse("2010/10/10");
		pstmt3.setDate(5, new java.sql.Date(utilDate.getTime()));
		pstmt3.setDouble(6, 8000.99);
		pstmt3.setInt(7, 70);
		pstmt3.setInt(8, 40);
		int rowCount3 = pstmt3.executeUpdate();
		System.out.println(">> Insert 9003 -> " + rowCount3 + "행 Insert");
		pstmt3.close();
		
		System.out.println(" ------------- UPDATE -------------");
		String updateSql = "UPDATE EMP SET SAL = SAL * ? WHERE EMPNO >= ? AND EMPNO <= ?";
		PreparedStatement pstmt4 = con.prepareStatement(updateSql);
		pstmt4.setDouble(1, 1.1);
		pstmt4.setInt(2, 9000);
		pstmt4.setInt(3, 9999);
		int rowCount4 = pstmt4.executeUpdate();
		System.out.println(">> " + rowCount4 + "행 Update");
		pstmt4.close();
		
	}

}
