package com.javaex.author01;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDAO authordao = new AuthorDAO();

		//삽입
		authordao.Insert("이문열","경북 영양");
		authordao.Insert("박경리","경상남도 통영");

		
		
		//수정
		authordao.Update(2, "수정 - 박경리", "수정 - 경남통영");
		//삭제
		authordao.Delete(2);
		
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
