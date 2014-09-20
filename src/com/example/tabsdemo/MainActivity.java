package com.example.tabsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends FragmentActivity implements OnClickListener{
	RelativeLayout you;
	RelativeLayout me;
	RelativeLayout he;
	private FragmentManager fragmentManager;
	
	YouFragment youFragment;
	MeFragment meFragment;
	HeFragment heFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		you = (RelativeLayout) findViewById(R.id.you);
		me = (RelativeLayout) findViewById(R.id.me);
		he = (RelativeLayout) findViewById(R.id.he);
		
		fragmentManager = getSupportFragmentManager();
		
		initTabs();
	}

	private void initTabs() {
		youFragment = new YouFragment();
		meFragment = new MeFragment();
		heFragment = new HeFragment();
		
		you.setOnClickListener(this);
		me.setOnClickListener(this);
		he.setOnClickListener(this);
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.container, youFragment);
		transaction.add(R.id.container, meFragment);
		transaction.add(R.id.container, heFragment);
		
		transaction.show(youFragment);
		transaction.hide(heFragment);
		transaction.hide(meFragment);
		transaction.commit();
		
		you.setBackgroundColor(Color.RED);
		me.setBackgroundColor(Color.BLUE);
		he.setBackgroundColor(Color.BLUE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.you:
			you();
			break;
		case R.id.me:
			me();
			break;
		case R.id.he:
			he();
			break;

		default:
			break;
		}
	}
	
	private void you() {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.show(youFragment);
		transaction.hide(heFragment );
		transaction.hide(meFragment);
		transaction.commit();
		
		you.setBackgroundColor(Color.RED);
		me.setBackgroundColor(Color.BLUE);
		he.setBackgroundColor(Color.BLUE);
	}
	
	private void me() {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.show(meFragment);
		transaction.hide(youFragment);
		transaction.hide(heFragment);
		transaction.commit();
		me.setBackgroundColor(Color.RED);
		you.setBackgroundColor(Color.BLUE);
		he.setBackgroundColor(Color.BLUE);
	}
	
	private void he() {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.show(heFragment);
		transaction.hide(youFragment);
		transaction.hide(meFragment);
		transaction.commit();
		
		he.setBackgroundColor(Color.RED);
		you.setBackgroundColor(Color.BLUE);
		me.setBackgroundColor(Color.BLUE);
	}
}
