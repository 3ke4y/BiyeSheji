package com.rotk.mcjourney;


import com.example.mcjourney.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		findViewById(R.id.btn_login).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goLogin();
			}
		});
	}

	protected void goLogin() {
		// TODO Auto-generated method stub
		Intent itnt = new Intent(LoginActivity.this,MainActivity.class);
		startActivity(itnt);
		finish();
	}
}
