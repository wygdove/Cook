package com.wygdove.final_thecook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.wygdove.adapt.ListViewAdapter;
import com.wygdove.adapt.ViewPagerAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity implements OnClickListener {

	private ViewPager viewpager_showDishes;
	private ViewPagerAdapter adapter_viewpager;
	private ListView listview_show;
	private ListViewAdapter adapter_listview;
	private Button button_haveMateial;
	private Button button_toCook;
	private Button button_myCollect;
	
	private int[] image={R.drawable.t01,R.drawable.t02,R.drawable.t03,R.drawable.t04,R.drawable.t05,R.drawable.t06,R.drawable.t07,R.drawable.t08,R.drawable.t09,R.drawable.t10,R.drawable.t11,R.drawable.t12,R.drawable.t13,R.drawable.t14,R.drawable.t15,R.drawable.t16,R.drawable.t17,R.drawable.t18,R.drawable.t19,R.drawable.t20};
	private String[] listshow={"今日推荐","好评最多","名吃招牌"};
	private List<ImageView> list_imageview;
	
	private Random random=new Random(); 
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewpager_showDishes=(ViewPager)findViewById(R.id.viewpager_showRandomDishes);
        listview_show=(ListView)findViewById(R.id.listview_showStartMenu);
        button_haveMateial=(Button)findViewById(R.id.button_haveMateial);
        button_toCook=(Button)findViewById(R.id.button_toCook);
        button_myCollect=(Button)findViewById(R.id.button_myCollect);
        
        showViewPager();
        showListView();
        button_haveMateial.setOnClickListener(this);
        button_toCook.setOnClickListener(this);
        button_myCollect.setOnClickListener(this);
    }
    
    private void showViewPager() {
    	list_imageview =new ArrayList<ImageView>();
 		for(int i=0;i<3;i++) {
 	    	int x=random.nextInt(3);
 			ImageView imageView=new ImageView(this);
 			imageView.setImageResource(image[x]);
 			list_imageview.add(imageView);
 		}
 		adapter_viewpager=new ViewPagerAdapter(list_imageview);
 		viewpager_showDishes.setAdapter(adapter_viewpager);
    }
    
    private void showListView() {
    	ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listshow);
        listview_show.setAdapter(adapter);
        listview_show.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				Intent intent=new Intent(MainActivity.this,ShowAllDishesAcitvity.class);
				startActivity(intent);
			}
		});
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_haveMateial:
			Intent intent=new Intent(MainActivity.this,IngredientSearchActivity.class);
			startActivity(intent);
			break;
		case R.id.button_toCook:
			Intent intent2=new Intent(MainActivity.this,ShowAllDishesAcitvity.class);
			startActivity(intent2);
			break;
		case R.id.button_myCollect:
			Intent intent3=new Intent(MainActivity.this,ShowAllDishesAcitvity.class);
			startActivity(intent3);
			break;
		default:
			break;
		}
	}
}
