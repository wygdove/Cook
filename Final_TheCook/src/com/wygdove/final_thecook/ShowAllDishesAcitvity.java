package com.wygdove.final_thecook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import bin.Data;

import com.wygdove.Bean.DishesInfo;
import com.wygdove.adapt.LAdapter;
import com.wygdove.adapt.ListAdapter;

public class ShowAllDishesAcitvity extends Activity {

    private String[] dishes_name = { "鱼香肉丝", "豆腐烧鱼块", "莴笋萝卜豆腐丁", "蒜炒鸡蛋", "糖醋鱼", "豆腐烧肉" };
    private String[] dishes_introduce = {
	    "猪里脊肉切丝，用冷水浸泡直至泡出血水，同时黑木耳温水泡发肉丝加入料酒、淀粉、盐、少量植物油腌制半小时\n胡萝卜、笋子、黑木耳切丝待用调配鱼香汁：姜葱蒜切末，加入1勺盐、1勺淀粉、3勺酱油、4勺砂糖、4勺醋、5勺水调匀\n热锅热油倒入肉丝大火炒至肉丝变白\n转中火加入郫县豆瓣酱炒出红油倒入胡萝卜、笋子、黑木耳丝大火翻炒至熟\n倒入调配好的鱼香汁，约一分钟翻炒均匀即可出锅",
	    "准备食材：五花肉切细条，青红椒切细条，姜切片，葱切小段，将甜面酱、料酒、砂糖和酱油拌匀成调味料\n平底锅放入五花肉条煎成金黄，盛起待用\n炒锅放入少许油，爆香豆豉、姜片和葱段，放入肉丝翻炒一下\n加准备好的调味料，炒匀\n放入青红椒丝，翻炒至食材煮熟即可",
	    "备豆腐丁和辣椒\n再切点莴笋丁，红萝卜丁，蒿笋片，咖喱少许\n先煎豆腐，撒盐入味\n煎片刻\n煎香\n另起锅，放进莴笋，蒿笋，红萝卜丁\n放进辣椒提辣，撒盐入味\n倒进煎好的豆腐丁\n炒匀\n放进咖喱\n放清水\n煮二分钟\n撒上味精或鸡精\n再次烧开\n即成",
	    "小根蒜洗净切段\n打入鸡蛋\n加入盐搅拌均匀\n锅里加入油热后，倒入小根蒜蛋液翻炒\n如果炒的太干，可沿着锅边淋入一点点水炒熟。加入盐调味",
	    "黄花鱼洗净改刀，腌制好的鱼放入碗中鸡蛋地瓜粉打荷一起抹裹均匀\n把红烧汁淋到鱼身，放入香菜红尖椒丝装饰\n完成",
	    "备豆腐和咖喱，辣椒\n豆腐切丁，辣椒切丁\n煎好的米粉肉\n先煎豆腐丁\n撒盐煎香\n放进米粉肉\n放进尖椒提辣\n倒进清水\n放进咖喱\n煮二分钟\n撒上鸡精或味精\n有香葱撒上香葱\n即成" 
	    };
    private int[] dishes_image = { R.drawable.t01, R.drawable.t02, R.drawable.t03, R.drawable.t04, R.drawable.t05, R.drawable.t06, R.drawable.t07 };

	private ListView listview_show;
	private LAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Data d = new Data();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_finded_menu);
		listview_show = (ListView) findViewById(R.id.listview_show);
		adapter = new LAdapter(dishes_image, dishes_name, dishes_introduce,
				ShowAllDishesAcitvity.this);
		listview_show.setAdapter(adapter);

		listview_show.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent intent = new Intent(ShowAllDishesAcitvity.this,ShowInfo.class);
				DishesInfo dishes=new DishesInfo(dishes_image[position],dishes_name[position],dishes_introduce[position]);
				intent.putExtra("dishes", dishes);
				intent.putExtra("position", position);
				startActivityForResult(intent, 1);
			}
		});
	}

}
