package com.wygdove.final_thecook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import com.wygdove.mymultichecklistview.MyExpandableListViewAdapter;
import com.wygdove.mymultichecklistview.ItemInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

public class IngredientSearchActivity extends Activity {

	private ExpandableListView elistview_kind;
	private ExpandableListAdapter elist_adapter;
	private Button button_confirm;
	
	public List<String> elist_group;
	public List<List<String>> elist_child;
	private HashMap<String,Integer> mp=new HashMap<String,Integer>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitvity_ingredient_search);
		
		elistview_kind=(ExpandableListView) findViewById(R.id.expandablelistview_ingredientKind);
		button_confirm=(Button) findViewById(R.id.button_confirmSelectedIngredient);
		
		this.showelist();
		initdata();
		
		button_confirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Vector<String> ve=new Vector<String>();
				List<ItemInfo> checkedItems =((MyExpandableListViewAdapter) elist_adapter).getCheckedItems();
				for (ItemInfo item: checkedItems) {
					ve.add(item.getItemContent());
				}
				int[] num=new int[ve.size()];
				for (int i=0;i<ve.size();i++) {
					num[i]=mp.get(ve.get(i));
				}
				Intent intent=new Intent(IngredientSearchActivity.this,ShowAllDishesAcitvity.class);
				intent.putExtra("ingredients_number", num);
				startActivity(intent);
			}
		});
	}
	
	public void showelist() {
		elistview_kind = (ExpandableListView)findViewById(R.id.expandablelistview_ingredientKind);
		elistview_kind.setGroupIndicator(this.getResources().getDrawable(R.drawable.group_indicator));
		elistview_kind.setIndicatorBounds(5, 25);
		elistview_kind.setDivider(null);
		elist_adapter = new MyExpandableListViewAdapter(this);
		elistview_kind.setAdapter(elist_adapter);
		elistview_kind.setItemsCanFocus(true);		
		elistview_kind.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void initdata() {
		mp.put("ÖíÈâ",1); mp.put("Ëñ",2); mp.put("Ä¾¶ú",3); mp.put("À±½· ",4);
		mp.put("¶¹¸¯ ",5); mp.put("ÓãÈâ",6); mp.put("ºìÂÜ²·",7); mp.put("Ëâ",8);
		mp.put("¼¦µ°",9); mp.put("ÇÑ×Ó",10); mp.put("Çà²Ë",11); mp.put("ÍÁ¶¹",12);
		mp.put("´óÃ×",13); mp.put("»¨Éú",14);
	}

}
