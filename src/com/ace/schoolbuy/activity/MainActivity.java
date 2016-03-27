package com.ace.schoolbuy.activity;

import android.support.v7.app.ActionBarActivity;

import com.ace.schoolbuy.R;
import com.ace.schoolbuy.R.id;
import com.ace.schoolbuy.R.layout;
import com.ace.schoolbuy.R.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import cn.bmob.v3.Bmob;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bmob.initialize(this, "e7258ecfce17c29d9210c84a835d6d79");
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
