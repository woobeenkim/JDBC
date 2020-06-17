package com.javaex.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInsert {
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
			String Query = "INSERT INTO author VALUES (seq_author_id.nextval, ?, ? )";
			//문자열 만들기, ?는 아직 어떤 문자열이 몰라 비워놓음.
			pstmt = conn.prepareStatement(Query);
			pstmt.setString( 1 , "김영하"); //순서, 자료 입력. if(넣을 자료가 3개이고 두번쨰 칸을 채우려면 setString(2,"자료")
			pstmt.setString( 2 , "알쓸신잡");
			
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

}
