package com.cook.db.dao;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import com.cook.db.CookSQLiteOpenHelper;
import com.cook.R;
import com.cook.bean.Dishes;

public class DishesDao {

	private static final String TAG = "DishesDao";
	private static final String TABLE_NAME = "dishes";
	private SQLiteDatabase db1;
	private static Context context;
    String path = "/data/data/com.cook/files/cook.db";
	public DishesDao(Context context) {
		this.context=context;
		
	}
	
	public boolean addDishes(Dishes dishes){
        SQLiteDatabase db = db1.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        ContentValues values = new ContentValues();
        values.put("name",dishes.getDishesName());
        values.put("material",dishes.getDishesMaterial());
        values.put("introduce",dishes.getDishesIntroduce());
        values.put("way",dishes.getDishesWay());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Bitmap bitmap = ((BitmapDrawable)context.getResources().getDrawable(R.id.imagebutton_collect)).getBitmap();
	    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
	    byte[] image=baos.toByteArray();
        values.put("image", image);
        long id = db.insert(TABLE_NAME, "classId", values);
        db.close();
        if (id != -1) {
            return true;
        } 
        else {
            return false;
        }
    }
	
	/**
	 * 获得所有的菜谱
	 * @return
	 */
	public List<Dishes> GetAllDishes() {
		SQLiteDatabase db = db1.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
		String sql = "select * from dishes";
		Cursor cursor = db.rawQuery(sql, null);
		List<Dishes> infos = new ArrayList<Dishes>();
		while (cursor.moveToNext()) {
			String id1=cursor.getString(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String mater = cursor.getString(cursor.getColumnIndex("material"));
			String introduce = cursor.getString(cursor.getColumnIndex("introduce"));
			String way = cursor.getString(cursor.getColumnIndex("way"));
			byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
			Dishes info=new Dishes(id1,name,mater,introduce,way,image);
			infos.add(info);
		}
		cursor.close();
		db.close();
		return infos;
	}
	
	/**
	 * 
	 * @param mater1
	 * @return
	 */
	public List<Dishes> FindDishesByMaterial(String searchMaterial) {
		Set<Dishes> infos = new TreeSet<Dishes>();
		String[] materials=searchMaterial.split(",");
		
		SQLiteDatabase db = db1.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
		//select * from table_name where 列名 like '%'||字符串||'%'
		String sql = "select * from dishes where material like '%'||?||'%'";//where material like '%?%'
		Cursor cursor = null;
		for(String material:materials) {
			cursor = db.rawQuery(sql, new String[]{material});
			while (cursor.moveToNext()) {
				String id1=cursor.getString(cursor.getColumnIndex("_id"));
				String name = cursor.getString(cursor.getColumnIndex("name"));
				String mater = cursor.getString(cursor.getColumnIndex("material"));
				String introduce = cursor.getString(cursor.getColumnIndex("introduce"));
				String way = cursor.getString(cursor.getColumnIndex("way"));
				byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
				Dishes info=new Dishes(id1,name,mater,introduce,way,image);
				infos.add(info);
			}
		}
		cursor.close();
		db.close();
		List<Dishes> list_infos=new ArrayList<Dishes>();
		Iterator<Dishes> it=infos.iterator();
		while(it.hasNext()) {
			list_infos.add(it.next());
		}
		return list_infos;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Dishes FindDishesByID(String id){
		Dishes info = null;
		SQLiteDatabase db = db1.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
		String sql="select * from dishes where _id=?";
		Cursor cursor = db.rawQuery(sql, new String[] { id });
		while(cursor.moveToNext()){
			String id1=cursor.getString(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String mater = cursor.getString(cursor.getColumnIndex("material"));
			String introduce = cursor.getString(cursor.getColumnIndex("introduce"));
			String way = cursor.getString(cursor.getColumnIndex("way"));
			byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
			info=new Dishes(id1,name,mater,introduce,way,image);
		}
		cursor.close();
		db.close();
		return info;
	}

}
