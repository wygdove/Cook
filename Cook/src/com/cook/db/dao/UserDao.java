package com.cook.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cook.db.CookSQLiteOpenHelper;
import com.cook.bean.Dishes;
import com.cook.bean.User;

public class UserDao {
	private static final String TAG = "UserDao";
	private static final String TABLE_NAME = "User";
	private static CookSQLiteOpenHelper helper;

	public UserDao(Context context) {
		helper = new CookSQLiteOpenHelper(context);
	}

	/**
	 * 传进来一个user对象，保存在数据库中
	 * @param user
	 * @return
	 */
	public boolean addUser(String name,String password) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("password",password);
        long id = db.insert(TABLE_NAME, "classId", values);
        db.close();
        if (id != -1) {
            return true;
        } else {
            return false;
        }
    }
	
	/**
	 * 传进来一个user对象，登录验证
	 * @param user
	 * @return
	 */
	public boolean validateLogin(String name,String password) {
		SQLiteDatabase db=helper.getReadableDatabase();  
        String sql="select * from user where name=? and password=?";  
        Cursor cursor=db.rawQuery(sql, new String[]{name,password});         
        if(cursor.moveToFirst()==true) {  
            cursor.close();  
            return true;  
        }  
        return false;
	}
	
	/**
	 * 传进来一个user对象和一个新密码,更改用户密码
	 * @param user
	 * @param newpswd
	 * @return
	 */
	public boolean changePassword(User user,String newpswd) {
		SQLiteDatabase db = helper.getReadableDatabase();
		String sql="update user set password = ? where password = ?";
		Cursor cursor = db.rawQuery(sql, new String []{newpswd,user.getUserPassword()});
		if(cursor.moveToFirst()==true) {
			cursor.close();
			return true;
		}
		return false;
	}

	public User getUser(String name) {
		SQLiteDatabase db = helper.getReadableDatabase();
		User user = null;
		String sql="select * from user where name=?";
		Cursor cursor = db.rawQuery(sql, new String[] { name });
		while(cursor.moveToNext()){
			String id1=cursor.getString(cursor.getColumnIndex("_id"));
			String name2 = cursor.getString(cursor.getColumnIndex("name"));
			String password2=cursor.getString(cursor.getColumnIndex("password"));
			user=new User(id1,name2,password2);
		}
		cursor.close();
		db.close();
		return user;
	}
	

}
