package com.rotk.mcjourney;

import com.example.mcjourney.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class LogoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		
		Handler handler=new Handler();
		 handler.postDelayed(new Runnable() {
		
		 public void run() {
		 //�ڲ����з����ⲿ����
		 //MainActivity.this.------
		 startLoginActivity();
		 }
		 }, 1500);
	}

	protected void startLoginActivity() {
		// TODO Auto-generated method stub
		Intent itnt = new Intent(this,LoginActivity.class);
		startActivity(itnt);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	//�Ȳ�ʵ�ַ���������
}
