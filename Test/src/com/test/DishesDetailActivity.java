package com.test;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DishesDetailActivity extends Activity {

	private ImageView imageview_dishesImage;
	private TextView textview_dishesName;
	private TextView textview_dishesIngredient;
	private TextView textview_dishesWay;
	private ImageButton imagebutton_collect;
	
	private Dishes dishes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dishes_detail);
		
		imageview_dishesImage=(ImageView)findViewById(R.id.imageview_dishesImage);
		textview_dishesName=(TextView)findViewById(R.id.textview_dishesName);
		textview_dishesIngredient=(TextView)findViewById(R.id.textview_dishesIngredient);
		textview_dishesWay=(TextView)findViewById(R.id.textview_dishesWay);
		
        Intent intent=getIntent();
        dishes=(Dishes) intent.getSerializableExtra("dishes");

		imageview_dishesImage.setImageBitmap(dishes.getDishesImage());
		textview_dishesName.setText(dishes.getDishesName());
		textview_dishesIngredient.setText(dishes.getDishesMaterial());
		textview_dishesWay.setText(dishes.getDishesWay());

	}
}
