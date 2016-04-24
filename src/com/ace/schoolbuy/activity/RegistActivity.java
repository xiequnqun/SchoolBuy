package com.ace.schoolbuy.activity;

import android.support.v7.app.ActionBarActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ace.schoolbuy.R;
import com.ace.schoolbuy.model.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class RegistActivity extends ActionBarActivity implements OnClickListener {
	private EditText registUsername;
	private EditText registPassword;
	private EditText registPassword2;
	private EditText registTel;
	private EditText registEmail;
	private Button registOK;
	private Button registCancel;
	private User mUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		Bmob.initialize(this, "e7258ecfce17c29d9210c84a835d6d79");
		initView();

	}

	private void initView() {
		registUsername = (EditText) findViewById(R.id.regist_name);
		registPassword = (EditText) findViewById(R.id.regist_password);
		registPassword2 = (EditText) findViewById(R.id.regist_password2);
		registTel = (EditText) findViewById(R.id.regist_tel);
		registEmail = (EditText) findViewById(R.id.regist_email);
		registOK = (Button) findViewById(R.id.regist_ok);
		registOK.setOnClickListener(this);
		registCancel = (Button) findViewById(R.id.regist_cancel);
		registCancel.setOnClickListener(this);
	}

	private void regist() {
		mUser = createUser();
		if (mUser != null) {
			mUser.signUp(this, new SaveListener() {

				@Override
				public void onSuccess() {
					Toast.makeText(RegistActivity.this, "ע��ɹ�", Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onFailure(int arg0, String arg1) {
					Toast.makeText(RegistActivity.this, "ע��ʧ��:" + arg1, Toast.LENGTH_SHORT).show();

				}
			});
			finish();
		}

	}

	private User createUser() {
		User mUser = new User();
		mUser.setUsername(registUsername.getText().toString());
		String pass1 = registPassword.getText().toString();
		String pass2 = registPassword2.getText().toString();
		if (pass1.equals(pass2) && pass1.length() > 7) {
			mUser.setPassword(pass1);
		} else {
			Toast.makeText(this, "�������벻һ�»��߳�������8λ", Toast.LENGTH_SHORT).show();
			mUser = null;
			return mUser;
		}
		String tel = registTel.getText().toString();
		if (checkTel(tel)) {
			mUser.setMobilePhoneNumber(tel);
		} else {
			Toast.makeText(this, "������Ϸ����ֻ���", Toast.LENGTH_SHORT).show();
			mUser = null;
			return mUser;
		}
		String email = registEmail.getText().toString();
		if (checkEmail(email)) {

			mUser.setEmail(email);
		} else {
			Toast.makeText(this, "������Ϸ�������", Toast.LENGTH_SHORT).show();
			mUser = null;
			return mUser;
		}

		return mUser;
	}

	/**
	 * ����������ʽ�ж��ֻ����Ƿ�Ϸ�
	 * 
	 * �ƶ���134��135��136��137��138��139��150��151��157(TD)��158��159��187��188
	 * 
	 * ��ͨ��130��131��132��152��155��156��185��186
	 * 
	 * ���ţ�133��153��180��189����1349��ͨ��
	 **/
	private boolean checkTel(String tel) {
		String regExp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern pattern = Pattern.compile(regExp);
		Matcher mat = pattern.matcher(tel);
		return mat.find();
	}

	// ��֤�����ʽ
	public boolean checkEmail(String email) {
		String regExp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regExp);
		Matcher mat = pattern.matcher(email);
		return mat.find();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.regist_ok:
			regist();
			break;
		case R.id.regist_cancel:
			finish();
			break;
		default:
			break;
		}

	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.regist, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
