package com.javaex.book02;

import java.util.List;

public class BookApp {
	public static void main(String[] args)
	{
		BookDAO bd = new BookDAO();
	
		//입력
		/*
		BookVo vo1 = new BookVo("26년","재미주의","2012-02-04",5);
		bd.Insert(vo1);
		*
		//수정
		BookVo vo2 = new BookVo(1,"수정- 우리들의 일그러진 영웅","다림","1998-02-22",1);
		bd.Update(vo2);
		*/
		//삭제
		//bd.Delete(10);
		//출력
		List<BookVo> BL = bd.BList();
		

		System.out.println("===========");
		for(BookVo bv : BL)
		{
			System.out.println(bv.getBook_id() + ", "
		+ bv.getBook_name()+", "
		+bv.getPubs()+ ", "
		+bv.getPub_date()+", "
		+bv.getAauthor_id()+", "
		+bv.getAuthor_name()+", "
		+bv.getAuthor_desc()
		);
		}
		System.out.println("===========");
		
	}
}
