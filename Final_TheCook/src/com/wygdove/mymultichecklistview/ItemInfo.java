package com.wygdove.mymultichecklistview;

public class ItemInfo {

	private int groupPosition;
	private int childPosition;
	private String itemContent;
	
	public ItemInfo() {}
	
	public ItemInfo(int groupPosition, int childPosition, String itemContent) {
		super();
		this.groupPosition = groupPosition;
		this.childPosition = childPosition;
		this.itemContent = itemContent;
	}

	public int getGroupPosition() {
		return groupPosition;
	}

	public void setGroupPosition(int groupPosition) {
		this.groupPosition = groupPosition;
	}

	public int getChildPosition() {
		return childPosition;
	}

	public void setChildPosition(int childPosition) {
		this.childPosition = childPosition;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

}