package com.javaex.book01;

import java.util.List;

public class BookApp {
	public static void main(String[] args)
	{
		BookDAO bd = new BookDAO();
		
		/*
		//입력
		bd.Insert("우리들의 일그러진 영웅","다림","1998-02-22",1);
		bd.Insert("삼국지","민음사","2002-03-01",1);
		bd.Insert("토지","마로니에북스","2012-08-15",2);
		bd.Insert("유시민의 글쓰기 특강","생각의길","2015-04-01",3);
		bd.Insert("패션왕","중앙북스(books)","2012-02-22",4);
		bd.Insert("순정만화","재미주의","2011-08-03",5);
		bd.Insert("오직두사람","문학동네","2017-05-04",6);
		bd.Insert("26년","재미주의","2012-02-04",5);
		*/
		
		//수정
		//bd.Update(1,"수정 - 삼국지","민음사","2002-03-01",2);
		
		//삭제
		//bd.Delete(9);
		//출력
		List<BookVo> BL = bd.BList();
		

		System.out.println("===========");
		for(BookVo bv : BL)
		{
			System.out.println(bv.getBook_id() + ", "
		+ bv.getBook_name()+", "
		+bv.getPubs()+ ", "
		+bv.getPub_date()+", "
		+bv.getAuthor_id());
		}
		System.out.println("===========");
		
	}
}
