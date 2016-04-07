package com.cook.adapter;

import java.util.ArrayList;
import java.util.List;

import com.cook.R;
import com.cook.bean.BitmapAndBytes;
import com.cook.bean.Dishes;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter_Dishes extends BaseAdapter {

	private List<Dishes> list_dishes=new ArrayList<Dishes>();
	private Context context;
	
	public ListViewAdapter_Dishes() {}

	public ListViewAdapter_Dishes(List<Dishes> list_dishes,Context context) {
		this.context=context;
		this.list_dishes=list_dishes;
	}

	@Override
	public int getCount() {
		return list_dishes.size();
	}

	@Override
	public Object getItem(int position) {
		return list_dishes.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		
//		convertView=LayoutInflater.from(context).inflate(R.layout.list_item, null);
//		
//		ImageView imageview_icon=(ImageView) convertView.findViewById(R.id.imageview_dishesImage);
//		TextView textview_name=(TextView) convertView.findViewById(R.id.textview_dishesName);
//		TextView textview_sign=(TextView) convertView.findViewById(R.id.textview_dishesIntroduce);
//		imageview_icon.setImageBitmap(c);
//		textview_name.setText(list_dishes.get(position).getDishesName());
//		textview_sign.setText(list_dishes.get(position).getDishesIntroduce());
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
			holder.imageview_icon = (ImageView) view.findViewById(R.id.imageview_dishesImage);
			holder.textview_name = (TextView) view.findViewById(R.id.textview_dishesName);
			holder.textview_introduce = (TextView) view.findViewById(R.id.textview_dishesIntroduce);
			view.setTag(holder);
		} 
		else {
			view = convertView;
		}
		holder = (ViewHolder) view.getTag();
		holder.imageview_icon.setImageBitmap(BitmapAndBytes.Bytes2Bitmap(list_dishes.get(position).getDishesImage()));
		holder.textview_name.setText(list_dishes.get(position).getDishesName());
		holder.textview_introduce.setText(list_dishes.get(position).getDishesIntroduce());
		return view;
	}
	
	class ViewHolder {
		ImageView imageview_icon;
		TextView textview_name;
		TextView textview_introduce;
	}
}

