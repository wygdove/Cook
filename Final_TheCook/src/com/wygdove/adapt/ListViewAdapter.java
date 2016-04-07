package com.wygdove.adapt;

import com.wygdove.final_thecook.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	private int[] image;
	private String[] name;
	private String[] introduce;
	private Context context;
	
	public ListViewAdapter() {}

	public ListViewAdapter(int[] image,String[] name,String[] introduce,Context context) {
		this.image=image;
		this.name=name;
		this.introduce=introduce;
		this.context=context;
	}

	@Override
	public int getCount() {
		return name.length;
	}

	@Override
	public Object getItem(int position) {
		return name[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		convertView=LayoutInflater.from(context).inflate(R.layout.list_item, null);
		
		ImageView imageview_icon=(ImageView) convertView.findViewById(R.id.imageview_icon);
		TextView textview_name=(TextView) convertView.findViewById(R.id.textview_dishesName);
		TextView textview_sign=(TextView) convertView.findViewById(R.id.textview_disesIntroduce);
		imageview_icon.setImageResource(image[position]);
		textview_name.setText(name[position]);
		textview_sign.setText(introduce[position]);

		return convertView;
	}	

}