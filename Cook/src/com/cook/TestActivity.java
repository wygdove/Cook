package com.cook;

import com.cook.bean.BitmapAndBytes;
import com.cook.bean.Dishes;
import com.cook.bean.User;
import com.cook.db.dao.CollectDao;
import com.cook.db.dao.DishesDao;
import com.cook.db.dao.UserDao;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import junit.framework.Test;

public class TestActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dishes_detail);
		AgentApplication.addActivity(TestActivity.this);

		
	}
}
