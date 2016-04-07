package com.cook.adapter;

import com.cook.R;

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

//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		
//		convertView=LayoutInflater.from(context).inflate(R.layout.list_item, null);
//		
//		ImageView imageview_icon=(ImageView) convertView.findViewById(R.id.imageview_dishesImage);
//		TextView textview_name=(TextView) convertView.findViewById(R.id.textview_dishesName);
//		TextView textview_sign=(TextView) convertView.findViewById(R.id.textview_dishesIntroduce);
//		imageview_icon.setImageResource(image[position]);
//		textview_name.setText(name[position]);
//		textview_sign.setText(introduce[position]);
//
//		return convertView;
//	}	

//}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		View view = null;
		if (convertView == null) {
			view = View.inflate(context, R.layout.list_item, null);
			holder = new ViewHolder();
			holder.imageview_icon = (ImageView) view.findViewById(R.id.textview_dishesName);
			holder.textview_name = (TextView) view.findViewById(R.id.imageview_dishesImage);
			holder.textview_introduce = (TextView) view.findViewById(R.id.textview_dishesIntroduce);
			view.setTag(holder);
		} 
		else {
			view = convertView;
			holder = (ViewHolder) view.getTag();
		}
		
		holder.imageview_icon.setImageResource(image[position]);
		holder.textview_name.setText(name[position]);
		holder.textview_introduce.setText(introduce[position]);
		return view;
	}

}

class ViewHolder {
	ImageView imageview_icon;
	TextView textview_name;
	TextView textview_introduce;
}