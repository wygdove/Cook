package com.cook;

import java.util.ArrayList;
import java.util.List;

import com.cook.adapter.ListViewAdapter_Dishes;
import com.cook.bean.Dishes;
import com.cook.db.dao.DishesDao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class SearchResultActivity extends Activity {

	private ListView listview_result;
	private ListViewAdapter_Dishes adapter;
	private List<Dishes> list_dishes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);
		AgentApplication.addActivity(SearchResultActivity.this);
	
		listview_result=(ListView) findViewById(R.id.listview_result);
		
		
        Intent intent=getIntent();
        String selectedIngredient=intent.getStringExtra("selectedIngredient");
        DishesDao dishesdao=new DishesDao(SearchResultActivity.this);
        list_dishes=new ArrayList<Dishes>();
        list_dishes=dishesdao.FindDishesByMaterial(selectedIngredient);
        ListViewAdapter_Dishes adapter_listview=new ListViewAdapter_Dishes(list_dishes,SearchResultActivity.this);
    	listview_result.setAdapter(adapter_listview);
		
		listview_result.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent = new Intent(SearchResultActivity.this,DishesDetailActivity.class);
                Dishes dishes=new Dishes();
                dishes=list_dishes.get(position);
                intent.putExtra("dishes", dishes);
                startActivity(intent);
			}
		});
	}

}
