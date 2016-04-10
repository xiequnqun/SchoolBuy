package com.ace.schoolbuy.activity;

import android.support.v7.app.ActionBarActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ace.schoolbuy.R;
import com.ace.schoolbuy.R.id;
import com.ace.schoolbuy.R.layout;
import com.ace.schoolbuy.R.menu;
import com.ace.schoolbuy.bmob.BmobManager;
import com.ace.schoolbuy.model.User;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.Bmob;

public class RegistActivity extends ActionBarActivity implements OnClickListener {

	private BmobManager mManager;
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
		mManager = BmobManager.getInstance(this);
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
			mManager.Save(mUser);
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
			mUser.setTel(tel);
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
		String account = createAccount();
		mUser.setAccount(account);
		return mUser;
	}

	//��δʹ��
	private String setAccount(String account) {
		if (checkAccount(account)) {
			account = createAccount();
			setAccount(account);
		}
		return account;
	}

	// ����Ƿ��˺��Ƿ��Ѿ�����
	private boolean checkAccount(String account) {
		return true;
	}

	// �������6λ���ʺ�
	private String createAccount() {
		int random = (int) (Math.random() * 1000000);

		return random + "";
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
