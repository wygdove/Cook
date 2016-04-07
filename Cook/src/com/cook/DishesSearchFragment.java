package com.cook;

import java.util.List;
import java.util.Vector;

import com.cook.R;
import com.cook.mymultichecklistview.ItemInfo;
import com.cook.mymultichecklistview.MyExpandableListViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class DishesSearchFragment extends Fragment {

	private static Context context;
	
	private ExpandableListView elistview_kind;
	private ExpandableListAdapter elist_adapter;
	private Button button_confirm;
	private Button button_clear;
	
	private List<String> elist_group;
	private List<List<String>> elist_child;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {	// 设置单个Fragment页面
		View view = inflater.inflate(R.layout.fragment_dishes_search, container, false);
		context=getActivity();

		elistview_kind=(ExpandableListView)view.findViewById(R.id.expandablelistview_ingredientKind);
		button_confirm=(Button)view.findViewById(R.id.button_confirmSelectedIngredient);
		button_clear=(Button)view.findViewById(R.id.button_clearSelectedIngredient);
		
		this.showelist();
		
		button_confirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {			
                List<ItemInfo> checkedItems =((MyExpandableListViewAdapter) elist_adapter).getCheckedItems();
                String selectedIngredient="";
                for (ItemInfo item: checkedItems) {
                	selectedIngredient+=item.getItemContent()+",";
                }
                if(selectedIngredient.equals("")) {
                	Toast.makeText(context, "至少要选择一项哦~~", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(context,SearchResultActivity.class);
                    intent.putExtra("selectedIngredient", selectedIngredient);
                    startActivity(intent);
                }
			}
		});
		button_clear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showelist();
				((MyExpandableListViewAdapter) elist_adapter).clearCheckedItems();
				Vector<String> selectedIngredient=new Vector<String>();
                List<ItemInfo> checkedItems =((MyExpandableListViewAdapter) elist_adapter).getCheckedItems();
                for (ItemInfo item: checkedItems) {
                	selectedIngredient.add(item.getItemContent());
                }
				Log.d("ilistview", selectedIngredient.toString());
			}
		});
		
		return view;
	}
	
	public void showelist() {
		elistview_kind.setGroupIndicator(this.getResources().getDrawable(R.drawable.group_indicator));
		elistview_kind.setIndicatorBounds(5, 25);
		elistview_kind.setDivider(null);
		elist_adapter = new MyExpandableListViewAdapter(context,elistview_kind);
		elistview_kind.setAdapter(elist_adapter);
		elistview_kind.setItemsCanFocus(true);		
		elistview_kind.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}
	
}