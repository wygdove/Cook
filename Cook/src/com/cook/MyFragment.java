package com.cook;

import com.cook.bean.User;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MyFragment extends Fragment implements OnClickListener {

	private Button button_login;
	private Button button_collection;
	private Button button_systemset;
	private Button button_judge;
	private Button button_contactus;
	
	private static Context context;

	private User user=null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)// 设置单个Fragment页面
	{
		View view = inflater.inflate(R.layout.fragment_my, container, false);
		context=getActivity();
		
		button_login = (Button) view.findViewById(R.id.button_login);
		button_collection = (Button) view.findViewById(R.id.button_collection);
		button_systemset = (Button) view.findViewById(R.id.button_systemset);
		button_judge = (Button) view.findViewById(R.id.button_judge);
		button_contactus = (Button) view.findViewById(R.id.button_contactus);
		button_login.setOnClickListener(this);
		button_collection.setOnClickListener(this);
		button_systemset.setOnClickListener(this);
		button_judge.setOnClickListener(this);
		button_contactus.setOnClickListener(this);
		
		if(Current.isHadUser()) {
			user=Current.getUser();
			button_login.setText(user.getUserName());
			button_login.setClickable(false);
		}
		return view;
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_login:
			Intent intent1 = new Intent(context, LoginActivity.class);
			startActivity(intent1);
			break;
		case R.id.button_collection:
			if(Current.isHadUser()) {
				user=Current.getUser();
				Intent intent2 = new Intent(context, CollectionActivity.class);
				startActivity(intent2);
			}
			else {
				Toast.makeText(context, "请登录", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button_systemset:
			Intent intent3 = new Intent(context, SystemSetActivity.class);
			context.startActivity(intent3);
			break;
		case R.id.button_judge:
			Intent intent4 = new Intent(context, ScoreActivity.class);
			context.startActivity(intent4);
			break;		
		case R.id.button_contactus:
			Intent intent5 = new Intent(context, ContactUsActivity.class);
			context.startActivity(intent5);
			break;
		default:
			break;
		}
	}

}