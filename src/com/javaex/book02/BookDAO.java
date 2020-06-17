package com.javaex.book02;

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
	public void Insert(BookVo bookvo)
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
			pstmt.setString(1, bookvo.getBook_name());
			pstmt.setString(2, bookvo.getPubs());
			pstmt.setString(3, bookvo.getPub_date());
			pstmt.setInt(4, bookvo.getBauthor_id());


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
	public void Update(BookVo bookvo)
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

			pstmt.setString(1, bookvo.getBook_name());
			pstmt.setString(2, bookvo.getPubs());
			pstmt.setString(3, bookvo.getPub_date());
			pstmt.setInt(4, bookvo.getBauthor_id());
			pstmt.setInt(5, bookvo.getBook_id());
			
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
			Query += "select b.book_id book_id, "; 
			Query += " b.title title, "; 
			Query += " b.pubs pubs,  "; 
			Query += " to_char(b.pub_date, 'yyyy-mm-dd' ) pub_date, ";
			Query += " a.author_id author_id, "; 
			Query += " a.author_name author_name, "; 
			Query += " a.author_desc  author_Desc"; 
			Query += "  from book1 b, author1 a ";  
			Query += "  where a.author_id = b.author_id "; 
			Query += " order by book_id asc "; 
			
			pstmt = conn.prepareStatement(Query);
			
			rs = pstmt.executeQuery(); // 쿼리문 실행(정보 oracle로 보내기)
			
			//4.결과처리
			while(rs.next())
			{
				int bookID = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pub_date = rs.getString("pub_date");
				int aauthor_id = rs.getInt("author_id");
				String author_name = rs.getString("author_name");
				String author_desc = rs.getString("author_desc");
				
				
				BookVo bv = new BookVo(bookID, title, pubs, pub_date,aauthor_id,author_name,author_desc);
				BL.add(bv);
				
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
