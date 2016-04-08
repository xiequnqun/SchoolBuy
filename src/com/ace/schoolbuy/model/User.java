package com.ace.schoolbuy.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class User extends BmobObject {
	public User(){
		this.setTableName("User");
	}
	private String username;
	private String password;
	private String tel;
	private String email;
	private BmobFile header;
	private String account;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BmobFile getHeader() {
		return header;
	}
	public void setHeader(BmobFile header) {
		this.header = header;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
