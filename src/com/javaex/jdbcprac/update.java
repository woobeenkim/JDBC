package com.javaex.jdbcprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update {
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
			System.out.println("접속 성공!");
			
			//3. SQL문 준비/바인딩/실행
			String Query = "";
			Query += " update book ";
			Query += " set title = ?, ";
			Query += " pubs = ?, ";
			Query += " pub_date = ?, ";
			Query += " author_id = ? ";
			Query += " where book_id = ? ";
	
			pstmt = conn.prepareStatement(Query);
			
			
			//받는 값 가정

			pstmt.setString(1, "오직두사람");
			pstmt.setString(2, "문학동네");
			pstmt.setString(3, "2017-05-04");
			pstmt.setInt(4, 6);
			pstmt.setInt(5, 8);
			
			int count = pstmt.executeUpdate();
			//4.결과처리
			System.out.println(count + "건이 처리되었습니다.");
			
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
