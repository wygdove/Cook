package com.wygdove.final_thecook;

import com.wygdove.Bean.DishesInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowInfo extends Activity {
	private TextView textViewname;
	private ImageView imageView;
	private TextView textViewinfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showinfo);
		textViewname = (TextView) findViewById(R.id.edittext_name);
		textViewinfo = (TextView) findViewById(R.id.edittext_sign);
		imageView = (ImageView) findViewById(R.id.imageview_icon);
		Intent intent=getIntent();
		DishesInfo dishes=(DishesInfo) intent.getSerializableExtra("dishes");
		int position=intent.getIntExtra("position", -1);
		imageView.setImageResource(dishes.getImage());
		textViewname.setText(dishes.getDishes_name());
		textViewinfo.setText(dishes.getDishes_steps());
		
		textViewname.setFocusable(false);
		textViewname.setFocusableInTouchMode(false);
		textViewinfo.setFocusable(false);
		textViewinfo.setFocusableInTouchMode(false);
		
	}
}
