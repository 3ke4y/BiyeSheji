package com.rotk.mcjourney;

import java.util.ArrayList;
import java.util.List;

import com.example.mcjourney.R;

import Fragment.GroupFragment;
import Fragment.ItemFragment;
import Fragment.MainFragment;
import Fragment.MainTabbarFragment;
import Fragment.MainTabbarFragment.OnSelectedListener;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity implements OnClickListener{

	private ViewPager mainViewPager;
	private FragmentPagerAdapter mainPageAdapter;
	private List<Fragment> mFragments; //首页滑动fragment页
	
	private ImageView tabMain;
	private ImageView tabItem;
	private ImageView tabGroup;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		
		initView(); //初始化定义
		initEvent(); //初始化点击监听
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		tabMain.setOnClickListener(this);
		tabItem.setOnClickListener(this);
		tabGroup.setOnClickListener(this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		mainViewPager = (ViewPager) findViewById(R.id.viewpager_content);
		
		tabMain = (ImageView) findViewById(R.id.tab_main);
		tabItem = (ImageView) findViewById(R.id.tab_item);
		tabGroup = (ImageView) findViewById(R.id.tab_group);
		
		mFragments = new ArrayList<Fragment>();
		Fragment tab1 = new MainFragment();
		Fragment tab2 = new ItemFragment();
		Fragment tab3 = new GroupFragment();
		mFragments.add(tab1);
		mFragments.add(tab2);
		mFragments.add(tab3);
		
		mainPageAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mFragments.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return mFragments.get(arg0);
			}
		};
		mainViewPager.setAdapter(mainPageAdapter);
		mainViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// 当前页面被选中
				int currentItem = mainViewPager.getCurrentItem();
				setTab(currentItem);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	//点击监听 有三页中的哪页
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tab_main:
			setSelect(0);
			break;
		case R.id.tab_item:
			setSelect(1);
			break;
		case R.id.tab_group:
			setSelect(2);
			break;
		default:
			break;
		}
	}
	
	private void setSelect(int i) {
		
		setTab(i);
		mainViewPager.setCurrentItem(i);
	}

	protected void setTab(int i) {
		
		resetImgs();//重置图片为未点击状态
		
		
	}

	private void resetImgs() {
		// TODO Auto-generated method stub
		
	}
	
	

}
