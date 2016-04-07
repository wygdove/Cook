package com.wygdove.adapt;


import bin.Data;

import com.wygdove.final_thecook.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	static class ViewHolder {
		TextView textView4name;
		TextView textView4info;
		ImageView imageView;
	}
	
	private Context context;

	public ListAdapter(
			Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {

		return Data.cp.length;
	}

	@Override
	public Object getItem(int arg0) {

		return Data.cp[arg0].getName();
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*
		 * �����Ż���Ĵ���
		 */
		ViewHolder viewHolder;
		//����ǵ�һ�λ�ȡconvertView
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.selectlist_demo, null);
			viewHolder = new ViewHolder();
			viewHolder.textView4name = (TextView) convertView
					.findViewById(R.id.name4dish);
			viewHolder.textView4info = (TextView) convertView
					.findViewById(R.id.info4dish);
			viewHolder.imageView = (ImageView) convertView
					.findViewById(R.id.pic4dish);
			convertView.setTag(viewHolder);
		} else {//convertView�Ѿ��õ�����ô���и��� 
			//ͨ��getTag()������ȡviewHolder
			viewHolder = (ViewHolder) convertView.getTag();
		}
		// //�������ļ�xmlת��Ϊview����
		// convertView = LayoutInflater.from(context).inflate(R.layout.listdemo,
		// null);
		// //�ҵ���view���ڲ��ؼ�
		//
		// ImageView imageView = (ImageView)
		// convertView.findViewById(R.id.touxiang);
		// TextView textView1 = (TextView)
		// convertView.findViewById(R.id.username);
		// TextView textView2 = (TextView)
		// convertView.findViewById(R.id.signature);
		// //����Ӧ��Դ����ؼ�����ʾ

		System.out.println("www "+Data.cp[position].getName());
		viewHolder.textView4name.setText(Data.cp[position].getName());
		viewHolder.textView4info.setText(Data.cp[position].getProcdure());
		viewHolder.imageView.setImageResource(Data.img[position]);
		return convertView;
	}
}