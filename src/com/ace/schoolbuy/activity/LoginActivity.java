package com.ace.schoolbuy.activity;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.ArrayList;

import com.ace.schoolbuy.R;
import com.ace.schoolbuy.R.id;
import com.ace.schoolbuy.R.layout;
import com.ace.schoolbuy.R.menu;
import com.ace.schoolbuy.bmob.BmobManager;
import com.ace.schoolbuy.model.Commodity;
import com.ace.schoolbuy.model.User;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

@SuppressWarnings("deprecation")
public class LoginActivity extends ActionBarActivity implements OnClickListener {
	private BmobManager mManager;
	private ImageView mHeader;
	private TextView mUsername;
	private EditText mAccount;
	private EditText mPassword;
	private TextView mRegist;
	private TextView mRetrieve;
	private Button mLogin;
	private String mName;
	private User mUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		Bmob.initialize(this, "e7258ecfce17c29d9210c84a835d6d79");
		mManager = BmobManager.getInstance(this);
		mHeader = (ImageView) findViewById(R.id.user_header);
		mHeader.setOnClickListener(this);
		mUsername = (TextView) findViewById(R.id.user_name);
		mAccount = (EditText) findViewById(R.id.user_account);
		mPassword = (EditText) findViewById(R.id.user_password);
		mRegist = (TextView) findViewById(R.id.user_regist);
		mRegist.setOnClickListener(this);
		mRetrieve = (TextView) findViewById(R.id.user_Retrieve);
		mRetrieve.setOnClickListener(this);
		mLogin = (Button) findViewById(R.id.user_login);
		mLogin.setOnClickListener(this);
		mUser = getCurrentUser();
		if (getCurrentUser() != null) {
			mName = mUser.getUsername();
			mUsername.setText(mName);
			mAccount.setText(mName);
		}

	}

	private void modifyHeader() {

	}

	private void modifyPassword() {

	}

	private void registAccount() {
		start(RegistActivity.class);
	}

	private void start(Class<?> cls) {
		startActivity(new Intent(this, cls));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.user_header:

			break;
		case R.id.user_regist:
			registAccount();
			break;
		case R.id.user_Retrieve:

			break;
		case R.id.user_login:
			login();
			break;
		default:
			break;
		}

	}

	private void login() {
		if (mName == null) {
			mName = mAccount.getText().toString();
		}
		String password = mPassword.getText().toString();
		if (mUser == null){
			mUser = new User();
			
		}
		mUser.setUsername(mName);
		mUser.setPassword(password);
		Log.d("ace", mName+password);
		mUser.login(this, new SaveListener() {
			
			
			@Override
			public void onSuccess() {
				Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onFailure(int arg0, String arg1) {
				Toast.makeText(LoginActivity.this, "登录失败:" + arg1, Toast.LENGTH_SHORT).show();

			}
		});
	}

	/**
	 * 获取本地用户
	 */
	private User getCurrentUser() {
		User mUser = BmobUser.getCurrentUser(this, User.class);
		if (mUser != null) {
			return mUser;
		} else {
			return null;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
