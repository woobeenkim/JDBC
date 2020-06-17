package com.javaex.jdbcprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class select {
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
			
			
			//3. SQL문 준비/바인딩/실행
			String Query = "";
			Query += "select book_id , "; 
			Query += " title, "; 
			Query += " pubs, "; 
			Query += " to_char(pub_date, 'yyyy-mm-dd' ) pub_date , ";
			Query += " author_id  "; 
			Query += "  from book "; 
			
			pstmt = conn.prepareStatement(Query);
			
			rs = pstmt.executeQuery(); // 쿼리문 실행(정보 oracle로 보내기)
			
			//4.결과처리
			while(rs.next())
			{
				int bookID = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pub_date = rs.getString("pub_date");
				String author_id = rs.getString("author_id");
				
				System.out.println(bookID + "\t"+title + "\t" + pubs + "\t"+ pub_date+ "\t"+ author_id);
				
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
