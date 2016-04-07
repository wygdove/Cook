package com.cook.mymultichecklistview;

import com.cook.R;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.TextView;

public class CheckableTextView extends TextView implements Checkable{

	private boolean isChecked = false;
	public CheckableTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public CheckableTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CheckableTextView(Context context) {
		super(context);
	}

	@Override
	public void setChecked(boolean checked) {
		isChecked = checked;
		setTextColor(checked? this.getContext().getResources().getColor(R.color.fgcolor):this.getContext().getResources().getColor(R.color.fgcolor));
	}

	@Override
	public boolean isChecked() {
		return isChecked;
	}

	@Override
	public void toggle() {
		isChecked = !isChecked;
	}

}
