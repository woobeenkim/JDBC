package com.javaex.author01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AuthorDAO {
	//필드
	
		//생성자
		public AuthorDAO() {};
		//g/s
		
		//메소드
		public void Insert(String name, String desc) 
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
					String Query = "INSERT INTO author1 VALUES(seq_author_id1.nextval, ?, ?)";
					pstmt = conn.prepareStatement(Query);
					pstmt.setString(1, name);
					pstmt.setString(2, desc);

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
						System.out.println("error."+ e);
					}
				}
		}
		
		
		//작가추가
		public void Update(int id, String name, String desc)
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
				Query += " update author1 ";
				Query += " set    author_name = ? ,";
				Query += "     	  author_desc = ? ";
				Query += " where  author_id = ? ";
		
				pstmt = conn.prepareStatement(Query);
				
				
				//받는 값 가정
				
				pstmt.setString(1, name);
				pstmt.setString(2, desc);
				pstmt.setInt(3, id);
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
					System.out.println("error."+ e);
				}
			}
		}
		
		//작가수정
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
				Query += " delete from author1 ";
				Query += " where author_id = ? ";

				
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
		//작가삭제
		public List<AuthorVo> AList()
		{
			
			List<AuthorVo> AL = new ArrayList<AuthorVo>();
			
			
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
				
					Query += "select author_id,  "; 
					Query += " author_name, "; 
					Query += " author_desc ";
					Query += "  from author1"; 
					Query += "  order by author_id asc"; 

			
					pstmt = conn.prepareStatement(Query);
					
					rs = pstmt.executeQuery(); // 쿼리문 실행(정보 oracle로 보내기)
					
					//4.결과처리
					while(rs.next())
					{
						int author_id = rs.getInt("author_id");
						String author_name = rs.getString("author_name");
						String author_desc = rs.getString("author_desc");
						
						//리스트에 추가
						AuthorVo av = new AuthorVo(author_id, author_name,author_desc);
						AL.add(av);
						
						//System.out.println(bookID + "\t"+title + "\t" + pubs + "\t"+ pub_date+ "\t"+ author_id+"\t"+author_name+"\t"+author_desc);
						
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
				return AL;
			
		}
		//작가 리스트
		//toString

}
