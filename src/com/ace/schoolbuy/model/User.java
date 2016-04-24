package com.ace.schoolbuy.model;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

public class User extends BmobUser {
	private BmobFile header;
	public BmobFile getHeader() {
		return header;
	}
	public void setHeader(BmobFile header) {
		this.header = header;
	}
	
}
