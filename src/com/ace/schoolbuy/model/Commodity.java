package com.ace.schoolbuy.model;

import java.util.ArrayList;

import com.ace.schoolbuy.control.SaveListener;

import android.content.Context;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Commodity extends BmobObject {
	private String Name;
	private Integer Id;
	private String Price;
	private String UserID;
	private String Description;
	private String Kind;
	private ArrayList<BmobFile> pics;
	private Integer number;
	public Commodity() {
		this.setTableName("Commodity");
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getKind() {
		return Kind;
	}
	public void setKind(String kind) {
		Kind = kind;
	}
	public ArrayList<BmobFile> getPics() {
		return pics;
	}
	public void setPics(ArrayList<BmobFile> pics) {
		this.pics = pics;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
}
