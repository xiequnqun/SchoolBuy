package com.ace.schoolbuy.control;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.CursorJoiner.Result;
import android.util.Log;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class BmobManager {
	private final static String TAG = "ace";
	private Context context;
	private static BmobQuery<BmobObject> query = new BmobQuery<BmobObject>();
	private BmobManager(Context context){
		this.context = context;
	}
	private BmobManager manager = null;
	public BmobManager getInstance(Context context){
		if (manager == null){
			manager = new BmobManager(context);
		}
		return manager;
	}
	public void Save(BmobObject obj) {
		obj.save(context, new SaveListener(context));
	}
	public void update(BmobObject obj) {
		
	}
	public void delete(BmobObject obj) {
		
	}
	//��������������ѯ
	public ArrayList<BmobObject> query(String key ,String value){
		final ArrayList<BmobObject> results = new ArrayList<BmobObject>();
		query.addWhereEqualTo(key, value);
		query.findObjects(context, new FindListener<BmobObject>() {
			
			@Override
			public void onSuccess(List<BmobObject> object) {
				Log.d(TAG, "��ѯ�ɹ�����"+object.size()+"�����ݡ�");
				for (BmobObject obj:object) {
					results.add(obj);
				}
			}
			
			@Override
			public void onError(int code, String msg) {
				Log.d(TAG, "��ѯʧ�ܣ�"+msg);
				
			}
		});
		return results;
	}
}
