package com.javaex.book01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	public BookDAO() {}

	//입력
	public void Insert(String Book_name, String pubs, String pub_date,int author_id)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC 드리이버 오라클 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			//3. SQL문 준비/바인딩/실행
			String Query = "INSERT INTO book1 VALUES(seq_book_id1.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, Book_name);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pub_date);
			pstmt.setInt(4, author_id);


			int count = pstmt.executeUpdate();
			//받는 값 가정
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
	
	//수정
	public void Update(int Book_id, String Book_name, String pubs, String pub_date, int author_id)
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
			Query += " update book1 ";
			Query += " set title = ?, ";
			Query += " pubs = ?, ";
			Query += " pub_date = ?, ";
			Query += " author_id = ? ";
			Query += " where book_id = ? ";
	
			pstmt = conn.prepareStatement(Query);
			
			
			//받는 값 가정

			pstmt.setString(1, Book_name);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pub_date);
			pstmt.setInt(4, author_id);
			pstmt.setInt(5, Book_id);
			
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
	
	//삭제
	public void Delete(int id)
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
			Query += " delete from book1 ";
			Query += " where book_id = ? ";

			
			pstmt = conn.prepareStatement(Query);
			
			pstmt.setInt(1, id);  //?에 대한 값 입력
			
			int count = pstmt.executeUpdate(); // 쿼리문 실행(정보 oracle로 보내기)
			//4.결과처리
			System.out.println(count + "건 이 처리되었습니다.");
			
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
	
	//리스트
	public List<BookVo> BList()
	{
		
		List<BookVo> BL = new ArrayList<BookVo>();
		
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
			Query += "  from book1 "; 
			
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
		return BL;
	}
}
