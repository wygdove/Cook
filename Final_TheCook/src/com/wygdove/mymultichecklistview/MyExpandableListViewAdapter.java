/**
 * 
 */
package com.wygdove.mymultichecklistview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wygdove.final_thecook.IngredientSearchActivity;
import com.wygdove.final_thecook.R;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {
	
	private Context context;
	private ItemInfo[] checkedItems;
	private boolean[][] checkedState;
	private String[] groupData={"Êß¹ûÀà","ÉúÏÊÀà","Îå¹ÈÀà"};
	final private String[][] itemData = {
			{"ÖñËñ","Ä¾¶ú","À±½·","¶¹¸¯","ºúÂÜ²·","Ëâ","ÇÑ×Ó","Çà²Ë","ÍÁ¶¹"},
			{"ÖíÈâ","ÓãÈâ","¼¦µ°"},
			{"´óÃ×"}
	};


	public MyExpandableListViewAdapter(Context context) {
		this.context = context;
		prepareData();
	}
	
	private void prepareData() {
		Log.d("ExpandableListView", "parepare data is called");
		checkedState=new boolean[itemData.length][]; 
		for (int i=0; i<itemData.length; i++) {
			checkedState[i] = new boolean[itemData[i].length];
			Arrays.fill(checkedState[i],false);
		}
	}
	
	public List<ItemInfo> getCheckedItems() {
		ArrayList<ItemInfo> checkedItems = new ArrayList<ItemInfo>(10); 
		for (int i=0; i<groupData.length; i++) 
			for (int j=0; j<itemData[i].length; j++) {
				if (checkedState[i][j]) {
					checkedItems.add(new ItemInfo(i, j, itemData[i][j]));
				}
			}
		return checkedItems;
	}
	
	@Override
	public int getGroupCount() {
		return groupData.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return itemData[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupData[groupPosition];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return itemData[groupPosition][childPosition];
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		View groupView = convertView;
		if (groupView == null) {
			groupView = new TextView(context);
			((TextView)groupView).setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
			groupView.setPadding(50,0,0,0);
		}
		((TextView)groupView).setText(groupData[groupPosition]);
		((TextView)groupView).setTextColor(context.getResources().getColor(R.color.fgcolor));
		
		return groupView;
	}

	private static class ViewHolder {
		TextView item;
		CheckableLinearLayout layout;
	}

	@Override
	public View getChildView(final int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		View itemView = convertView;
		final ViewHolder vh;
		if (itemView == null) {
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(R.layout.elist_item, null);
			
			vh = new ViewHolder();
			vh.layout = (CheckableLinearLayout)itemView.findViewById(R.id.layout);
			vh.item = (TextView)itemView.findViewById(R.id.item);
			itemView.setTag(vh);
		} else {
			vh = (ViewHolder)itemView.getTag();
		}
		vh.item.setText(itemData[groupPosition][childPosition]);
		final ExpandableListView listView = ((ExpandableListView)((IngredientSearchActivity)context).findViewById(R.id.expandablelistview_ingredientKind));
		final int position = listView.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
		listView.setItemChecked(position, checkedState[groupPosition][childPosition]);
		vh.layout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((CheckableLinearLayout)v).toggle();
				checkedState[groupPosition][childPosition] = !checkedState[groupPosition][childPosition]; 
				listView.setItemChecked(position, ((CheckableLinearLayout)v).isChecked());
			}
		});
		return itemView;
	}
	
	public boolean getCheckedState(int groupPosition, int childPosition) {
		return checkedState[groupPosition][childPosition];
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	@Override
	public void onGroupCollapsed(int groupPosition) {
		super.onGroupCollapsed(groupPosition);
	}

	@Override
	public void onGroupExpanded(int groupPosition) {
		super.onGroupExpanded(groupPosition);
	}

	
}
