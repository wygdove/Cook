//package com.test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.cook.bean.Dishes;
//import com.cook.bean.User;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//public class CollectDao {
//	private static final String TAG = "CollectDao";
//	private static final String TABLE_NAME = "collect";
//	private SQLiteDatabase db1;
//	private static Context context;
//	String path = "/data/data/com.cook/files/cook.db";
//
//	public CollectDao(Context context) {
//		this.context = context;
//	}
//
//	public boolean addCollection(String userid, String dishesid) {
//		SQLiteDatabase db = db1.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
//		ContentValues values = new ContentValues();
//		values.put("userid", userid);
//		values.put("foodid", dishes);
//		long id = db.insert(TABLE_NAME, "classId", values);
//		db.close();
//		if (id != -1) {
//			return true;
//		} else {
//			return false;
//		}
//
//	}
//
//	public boolean deleteCollection(User user, Dishes dishes) {
//		SQLiteDatabase db = db1.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
//		int id = db.delete(TABLE_NAME, "userid = ? and foodid=?",
//				new String[] { user.getUserID(), dishes.getDishesID() });
//		db.close();
//		if (id != -1)
//			return true;
//		else {
//			return false;
//		}
//
//	}
//	
//	public List<String> showCollection(User user){
//		SQLiteDatabase db = db1.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
//		String sql = "select * from collect where userid = ?";
//		String[] temp=new String [] {user.getUserID()};
//		Cursor cursor = db.rawQuery(sql,temp);
//		List<String> infos = new ArrayList<String>();
//		while (cursor.moveToNext()) {
//			String dishesid = cursor.getString(cursor.getColumnIndex("dishesid"));
//			infos.add(dishesid);
//		}
//		cursor.close();
//		db.close();
//		return infos;
//	
//	}
//
//	public boolean isCollected(User user, Dishes dishes) {
//		SQLiteDatabase db = db1.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
//		String sql="select * from collect where userid=? and dishesid=?";  
//        Cursor cursor=db.rawQuery(sql, new String[]{user.getUserID(),dishes.getDishesID()});         
//        if(cursor.moveToFirst()) {  
//            cursor.close();  
//            return true;  
//        }  
//        return false;
//	}
//
//}
