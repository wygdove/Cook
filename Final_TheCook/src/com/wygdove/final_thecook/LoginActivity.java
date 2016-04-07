package com.wygdove.final_thecook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText edittext_name=null;
	private EditText edittext_password=null;
	private Button 	button_register=null;
	private Button	button_login=null;

	private String name_input=null;
	private String password_input=null;
	private String name_read=null;
	private String password_read;

	private SharedPreferences sharedpre;
	private SharedPreferences.Editor editor;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		edittext_name		=(EditText)findViewById(R.id.edittext_name);
		edittext_password	=(EditText)findViewById(R.id.edittext_password);
		button_register		=(Button)findViewById(R.id.button_register);
		button_login		=(Button)findViewById(R.id.button_login);
		
		button_register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				name_input		=edittext_name.getText().toString();
				password_input	=edittext_password.getText().toString();
				
				sharedpre=getSharedPreferences("test", Activity.MODE_PRIVATE);
				editor=sharedpre.edit();
				editor.putString("name", name_input);
				editor.putString("password", password_input);
				editor.commit();
				Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_LONG).show();
			}
		});
		
		button_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				name_input		=edittext_name.getText().toString();
				password_input	=edittext_password.getText().toString();
				sharedpre=getSharedPreferences("test", Activity.MODE_PRIVATE);
				name_read		=sharedpre.getString("name", null);
				password_read	=sharedpre.getString("password", null);
				if(name_read.equals(null)) {
					new AlertDialog.Builder(LoginActivity.this)
					.setMessage("抱歉，没有这个用户")
					.setPositiveButton("确定",null)
					.show();
				}
				//else if(hashmap_user.containsKey(name)&&hashmap_user.get(name).equals(password)) {
				else if(name_read.equals(name_input)&&password_read.equals(password_input)) {
					Intent intent	=new Intent(LoginActivity.this,MainActivity.class);
					intent.putExtra("username", name_input);
					startActivity(intent);
				}
				else {
					new AlertDialog.Builder(LoginActivity.this)
					.setMessage("登陆失败，请核对用户名及密码")
					.setPositiveButton("确定",null)
					.show();
				}
			}
		});
	}
	
}

