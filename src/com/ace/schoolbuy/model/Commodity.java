package com.ace.schoolbuy.model;

import java.util.ArrayList;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Commodity extends BmobObject {
	private String Com_name;
	private Integer Com_price;
	private String Com_user;
	private String Com_description;
	private String Com_kind;
	private ArrayList<BmobFile> Com_pic;
	private Integer Com_number;
	public Commodity() {
		this.setTableName("Commodity");
	}
	public String getCom_name() {
		return Com_name;
	}
	public void setCom_name(String com_name) {
		Com_name = com_name;
	}
	public Integer getCom_price() {
		return Com_price;
	}
	public void setCom_price(Integer com_price) {
		Com_price = com_price;
	}
	public String getCom_user() {
		return Com_user;
	}
	public void setCom_user(String com_user) {
		Com_user = com_user;
	}
	public String getCom_description() {
		return Com_description;
	}
	public void setCom_description(String com_description) {
		Com_description = com_description;
	}
	public String getCom_kind() {
		return Com_kind;
	}
	public void setCom_kind(String com_kind) {
		Com_kind = com_kind;
	}
	public ArrayList<BmobFile> getCom_pic() {
		return Com_pic;
	}
	public void setCom_pic(ArrayList<BmobFile> com_pic) {
		Com_pic = com_pic;
	}
	public Integer getCom_number() {
		return Com_number;
	}
	public void setCom_number(Integer com_number) {
		Com_number = com_number;
	}
	
}
