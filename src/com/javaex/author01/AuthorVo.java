package com.javaex.author01;

public class AuthorVo {

	private int id;
	private String name;
	private String desc;
	
	public AuthorVo() {}
	public AuthorVo(int id, String name, String desc)
	{
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	@Override
	public String toString() {
		return "AuthorVo [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}
	
	
}
