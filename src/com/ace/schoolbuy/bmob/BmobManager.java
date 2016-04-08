package com.ace.schoolbuy.bmob;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.CursorJoiner.Result;
import android.util.Log;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class BmobManager {
	private final static String TAG = "ace";
	private Context context;
	private BmobManager(Context context){
		this.context = context;
		Bmob.initialize(context, "e7258ecfce17c29d9210c84a835d6d79");
	}
	private static BmobManager manager = null;
	public static BmobManager getInstance(Context context){
		if (manager == null){
			manager = new BmobManager(context);
		}
		return manager;
	}
	public void Save(BmobObject obj) {
		obj.save(context, new SaveListener() {
			@Override
			public void onSuccess() {
				Log.i(TAG,"添加成功：");
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				Log.i(TAG, "添加失败");
			}
		});
	}
	public void update(BmobObject obj) {
		obj.update(context, new UpdateListener() {
			
			@Override
			public void onSuccess() {
				Log.i(TAG,"更新成功：");
				
			}
			
			@Override
			public void onFailure(int code, String msg) {
				Log.i(TAG,"更新失败："+msg);
			}
		});
	}
	public void delete(BmobObject obj) {
		obj.delete(context, new DeleteListener() {
			
			@Override
			public void onSuccess() {
				Log.d(TAG, "删除成功");
				
			}
			
			@Override
			public void onFailure(int code, String msg) {
				Log.d(TAG, "删除失败:"+msg);
				
			}
		});
	}
	//根据所给条件查询多条数据
	public ArrayList<BmobObject> query(String key ,String value){
		final ArrayList<BmobObject> results = new ArrayList<BmobObject>();
		BmobQuery<BmobObject> query = new BmobQuery<BmobObject>();
		query.addWhereEqualTo(key, value);
		query.findObjects(context, new FindListener<BmobObject>() {
			
			@Override
			public void onSuccess(List<BmobObject> object) {
				Log.d(TAG, "查询成功：共"+object.size()+"条数据。");
				for (BmobObject obj:object) {
					results.add(obj);
				}
			}
			
			@Override
			public void onError(int code, String msg) {
				Log.d(TAG, "查询失败："+msg);
				
			}
		});
		return results;
	}
	BmobObject obj;
	public BmobObject getObject(String value,String table){
		BmobQuery<BmobObject> query = new BmobQuery<BmobObject>(table);
		query.getObject(context, value, new GetListener<BmobObject>() {
			
			@Override
			public void onFailure(int code, String msg) {
				Log.d(TAG, "查询失败"+msg);
				
			}
			
			@Override
			public void onSuccess(BmobObject object) {
				Log.d(TAG, "查询成功："+object.toString());
				obj = object;
				
			}
		});
		return obj;
	}
}
