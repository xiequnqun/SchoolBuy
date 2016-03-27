package com.ace.schoolbuy.control;

import android.content.Context;

public class SaveListener extends cn.bmob.v3.listener.SaveListener {
	Context context;
	public SaveListener(Context context) {
		this.context = context;
	}
	Toast toast = Toast.getInstance(context);
	@Override
	public void onFailure(int arg0, String arg1) {
		toast.toast("添加失败");
	}

	@Override
	public void onSuccess() {
		toast.toast("添加成功");

	}

}
