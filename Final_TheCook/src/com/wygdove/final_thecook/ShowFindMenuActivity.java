package com.wygdove.final_thecook;


import java.util.HashSet;

import com.wygdove.adapt.ListAdapter;
import com.wygdove.adapt.ListViewAdapter;

import bin.Data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ShowFindMenuActivity extends Activity {

	private ListView listview_show;
	private ListViewAdapter adapter;
	private String[] shicai ;
	private int[] shicai_num ;
	private String[] name;
	private String[] info;
	private int[] image;
	private ListAdapter listadapter;
	private ListView listView;

//	private int[] image={R.drawable.t01,R.drawable.t02,R.drawable.t03,R.drawable.t04,R.drawable.t05,R.drawable.t06,R.drawable.t07,R.drawable.t08,R.drawable.t09,R.drawable.t10,R.drawable.t11,R.drawable.t12,R.drawable.t13,R.drawable.t14,R.drawable.t15,R.drawable.t16,R.drawable.t17,R.drawable.t18,R.drawable.t19,R.drawable.t20};

	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listview_show);
		Intent intent1 = getIntent();
		shicai_num=intent1.getIntArrayExtra("ingredients_number");
//		shicai =intent1.getStringArrayExtra("ingredients_number");
//		for(int i=0;i<shicai.length;i++){
//			shicai_num[i]=Integer.valueOf(shicai[i]);
//		}
		Data d= new Data();
		HashSet<Integer>
		h=d.query(shicai_num);
		name=new String[h.size()];
		info=new String[h.size()];
		image=new int[h.size()];
		int k=0;
		for(int r:h){
			name[k]=Data.cp[r].name;
			info[k]=(Data.cp[r].procdure);
			image[k]=(Data.img[r]);
			k++;
		}
		
		listadapter = new ListAdapter(ShowFindMenuActivity.this);
		listView.setAdapter(listadapter);
		
		
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
	
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Intent intent = new Intent(ShowFindMenuActivity.this,ShowInfo.class);
				intent.putExtra("name", name[position]);
				intent.putExtra("info", info[position]);
				intent.putExtra("image", image[position]);
				startActivity(intent);
			}
		});
	}
}
