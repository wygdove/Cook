package com.wygdove.final_thecook;

import bin.Data;
import android.app.Activity;
import android.os.Bundle;

public class ShowDishesCookAcitvity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Data d=new Data();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_dishes_cook);
	}
	
}
