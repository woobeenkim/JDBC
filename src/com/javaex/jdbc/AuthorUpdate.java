package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorUpdate {
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
			Query += " update author ";
			Query += " set author_desc = ? ";
			Query += " where author_id = ? ";
	
			pstmt = conn.prepareStatement(Query);
			
			
			//받는 값 가정
			String desc = "서울특별시";
			int num = 5;
			
			pstmt.setString(1, desc);
			pstmt.setInt(2, num);
			
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
