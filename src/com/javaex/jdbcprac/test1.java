package com.javaex.jdbcprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test1 {
	public static void main(String[] args)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC 드리이버 오라클 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			
			//conn.setAutoCommit(false);
			
			//3. SQL문 준비/바인딩/실행
			
			//정보등록
			String Query = "INSERT INTO book1 VALUES(seq_book_id1.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(Query);
			System.out.println(Query);
			
			pstmt.setString(1, "26년");
			pstmt.setString(2, "재미주의");
			pstmt.setString(3, "2012-02-04");
			pstmt.setInt(4, 5);
			int count = pstmt.executeUpdate();
			
			//정보등록
			pstmt.setString(1, "26년");
			pstmt.setString(2, "재미주의");
			pstmt.setString(3, "2012-02-04");
			pstmt.setInt(4, 1000);
			int count1 = pstmt.executeUpdate();
			System.out.println(count1);
			
			conn.commit();
			//받는 값 가정
			//4.결과처리
			//System.out.println(count + "건이 처리되었습니다.");
		}catch(ClassNotFoundException e)
		{
			System.out.println("error.드라이버 로딩 실패 -"+ e);
		}catch(SQLException e)
		{
			System.out.println("error."+ e);
		}finally {
			//5.자원 정리
			try {
				if(pstmt != null)
				{
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("eroor."+ e);
			}
		}
	}
}
