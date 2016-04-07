package com.cook;

import com.cook.bean.BitmapAndBytes;
import com.cook.bean.Dishes;
import com.cook.bean.User;
import com.cook.db.dao.CollectDao;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DishesDetailActivity extends Activity {

	private ImageView imageview_dishesImage;
	private TextView textview_dishesName;
	private TextView textview_dishesIngredient;
	private TextView textview_dishesWay;
	private ImageButton imagebutton_collect;
	private CollectDao collectdao;
	
	private User user;
	private Dishes dishes;
	private boolean isCollected=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dishes_detail);
		AgentApplication.addActivity(DishesDetailActivity.this);
		
		imageview_dishesImage=(ImageView)findViewById(R.id.imageview_dishesImage);
		textview_dishesName=(TextView)findViewById(R.id.textview_dishesName);
		textview_dishesIngredient=(TextView)findViewById(R.id.textview_dishesIngredient);
		textview_dishesWay=(TextView)findViewById(R.id.textview_dishesWay);
		imagebutton_collect=(ImageButton)findViewById(R.id.imagebutton_collect);
		
        Intent intent=getIntent();
        dishes=(Dishes)intent.getSerializableExtra("dishes");

		if(Current.isHadUser()) {
			user=Current.getUser();
			collectdao=new CollectDao(DishesDetailActivity.this);
			isCollected=collectdao.isCollected(user,dishes);
		}
	
		Bitmap bm=BitmapAndBytes.Bytes2Bitmap(dishes.getDishesImage());
		imageview_dishesImage.setImageBitmap(bm);
		textview_dishesName.setText(dishes.getDishesName());
		textview_dishesIngredient.setText(dishes.getDishesMaterial());
		textview_dishesWay.setText(dishes.getDishesWay().replace("****", "\r\n"));
		if(isCollected) {
			imagebutton_collect.setImageResource(R.drawable.icon_collect_done);
		}
		else {
			imagebutton_collect.setImageResource(R.drawable.icon_collect_normal);
		}
	
		
		imagebutton_collect.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(!Current.isHadUser()) {
					Toast.makeText(DishesDetailActivity.this, "收藏失败，没有登录用户", Toast.LENGTH_SHORT).show();
				}
				else {
					if(!isCollected) {
						collectdao.addCollection(user, dishes);
						Toast.makeText(DishesDetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
						imagebutton_collect.setImageResource(R.drawable.icon_collect_done);
						isCollected=!isCollected;
					}
					else {
						collectdao.deleteCollection(user, dishes);
						Toast.makeText(DishesDetailActivity.this, "取消收藏成功", Toast.LENGTH_SHORT).show();
						imagebutton_collect.setImageResource(R.drawable.icon_collect_normal);
						isCollected=!isCollected;
					}
				}				
			}
		});
	}
}