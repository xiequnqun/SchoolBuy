package com.ace.schoolbuy.control;

import android.content.Context;

public class Toast extends android.widget.Toast {
	static Toast toast = null;
	private Toast(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	private Context context;
	public static Toast getInstance(Context context) {
		if(toast == null){
			toast = new Toast(context); 
		}
		return toast;
	}
	public void toast(String str){
		Toast.makeText(context, str, Toast.LENGTH_LONG).show();
	}

}
