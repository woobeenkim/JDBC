package com.javaex.book02;

public class BookVo {
	private int book_id;
	private String book_name;
	private String pubs;
	private String pub_date;
	private int bauthor_id;
	private int aauthor_id;
	private String author_name;
	private String author_desc;
	
	public BookVo() {}
	public BookVo(int book_id, String book_name, String pubs, String pub_date,int author_id)
	{
		this.book_id = book_id;
		this.book_name = book_name;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.bauthor_id = author_id;
	}
	public BookVo(String book_name, String pubs, String pub_date, int author_id)
	{
		this.book_name = book_name;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.bauthor_id = author_id;
	}
	
	public BookVo(int book_id, String book_name, String pubs, String pub_date, int aauthor_id, String author_name, String author_desc)
	{
		this.book_id = book_id;
		this.book_name = book_name;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.aauthor_id = aauthor_id;
		this.author_name = author_name;
		this.author_desc = author_desc;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getPubs() {
		return pubs;
	}
	public void setPubs(String pubs) {
		this.pubs = pubs;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public int getBauthor_id() {
		return bauthor_id;
	}
	public void setBauthor_id(int bauthor_id) {
		this.bauthor_id = bauthor_id;
	}
	public int getAauthor_id() {
		return aauthor_id;
	}
	public void setAauthor_id(int aauthor_id) {
		this.aauthor_id = aauthor_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getAuthor_desc() {
		return author_desc;
	}
	public void setAuthor_desc(String author_desc) {
		this.author_desc = author_desc;
	}
	@Override
	public String toString() {
		return "BookVo [book_id=" + book_id + ", book_name=" + book_name + ", pubs=" + pubs + ", pub_date=" + pub_date
				+ ", author_id=" + bauthor_id + "]";
	}
	

	
	
}
