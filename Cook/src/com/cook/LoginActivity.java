package com.cook;

import com.cook.bean.User;
import com.cook.db.dao.UserDao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class LoginActivity extends Activity {
 

    private EditText edittext_name=null;
    private EditText edittext_password=null;
    private Button button_register=null;
    private Button button_login=null;

    private User user=null;
    private UserDao userdao=null;
    
    private String name;
    private String password;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AgentApplication.addActivity(LoginActivity.this);
         
        edittext_name=(EditText)findViewById(R.id.edittext_name);
        edittext_password=(EditText)findViewById(R.id.edittext_password);
        button_register=(Button)findViewById(R.id.button_register);
        button_login=(Button)findViewById(R.id.button_login);
        userdao=new UserDao(LoginActivity.this);
        
        button_register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	name = edittext_name.getText().toString();
            	password = edittext_password.getText().toString();
            	if(name.equals("") || password.equals("")){
            		Toast.makeText(LoginActivity.this, "请填写完整", Toast.LENGTH_LONG).show();
            	}
            	else{
            		if(userdao.validateLogin(name,password)) {
            			new AlertDialog.Builder(LoginActivity.this)
            			.setMessage("已注册用户，请登录")
            			.setPositiveButton("确定",null)
            			.show();
            		}
            		else {
            			userdao.addUser(name,password);
            			Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_LONG).show();
            		}
            	}
            }
        });
         
        button_login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	name = edittext_name.getText().toString();
            	password = edittext_password.getText().toString();
            	if(name.equals("") || password.equals("")){
            		Toast.makeText(LoginActivity.this, "请填写完整", Toast.LENGTH_LONG).show();
            	}
            	else{
            		if(!userdao.validateLogin(name,password)) {
            			new AlertDialog.Builder(LoginActivity.this)
            			.setMessage("登录失败，请核对用户名及密码")
            			.setPositiveButton("确定",null)
            			.show();
            		}
            		else{
            			user=userdao.getUser(name);
            			Current.setUser(user);
            			Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            			startActivity(intent);
            		}
            	}
            }
        });
    }
     
}