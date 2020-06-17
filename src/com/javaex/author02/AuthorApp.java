package com.javaex.author02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDAO authordao = new AuthorDAO();
/*
		//삽입
		AuthorVo vo01 = new AuthorVo("강풀","온라인 만화가 1세대");
		authordao.Insert(vo01);
		
		
		AuthorVo vo02 = new AuthorVo("김영하","알쓸신잡");
		authordao.Insert(vo02);
		
		
		//수정
		AuthorVo vo03 = new AuthorVo(2,"수정 - 박경리", "수정 - 경상남도 통영");
		authordao.Update(vo03);
		//삭제
		//authordao.Delete(2);
*/
		//리스트 가져오기
		List<AuthorVo> AL = authordao.AList();
		//System.out.println(AL.get(1).getDesc());
		//출력
		System.out.println("===========");
		for(AuthorVo vo : AL)
		{
			
			System.out.println(vo.getId() + ", "+ vo.getName()+ ", "+ vo.getDesc());
			
		}
		System.out.println("===========");
		
	}

}
