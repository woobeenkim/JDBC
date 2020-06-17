package com.javaex.jdbcprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	public static void main(String[] args)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1. JDBC 드리이버 오라클 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속 성공!");
			
			//2.1 설정 변경
			
			
			//3. SQL문 준비/바인딩/실행
			
			String Query = "";
			Query += "select author_id , "; 
			Query += " author_name, "; 
			Query += " author_desc "; 
			Query += " from author"; 
			
			pstmt = conn.prepareStatement(Query);
			
			rs = pstmt.executeQuery(); // 쿼리문 실행(정보 oracle로 보내기)
			

			//-정보등록
			String Query1 = "";
			
			//4.결과처리
			while(rs.next())
			{
				int authorID = rs.getInt("author_id");
				String authorNAME = rs.getString("author_name");
				String authorDESC = rs.getString("author_desc");
				
				System.out.println(authorID + "\t"+authorNAME + "\t" + authorDESC);
				
			}
			
		}catch(ClassNotFoundException e)
		{
			System.out.println("error.드라이버 로딩 실패 -"+ e);
		}catch(SQLException e)
		{
			System.out.println("error."+ e);
		}finally {
			//5.자원 정리
			try {
				if(rs != null)
				{
					rs.close();
				}
				if(pstmt != null)
				{
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error."+ e);
			}
		}
	}
}
