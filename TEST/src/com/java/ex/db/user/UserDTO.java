package com.java.ex.db.user;

public class UserDTO {
	
	private String id;
	private String pw;
	private String name;
	private String position;
	private String str;
	private String num;
	
	public UserDTO (String id, String pw, String name, String position,String str, String num) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.position = position;
		this.str = str;
		this.num = num;

	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
