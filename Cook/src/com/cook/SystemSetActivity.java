package com.cook;

import com.cook.bean.User;
import com.cook.db.dao.UserDao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SystemSetActivity extends Activity {

	private ListView listview_set;
	
    private String[] setOption={"修改密码","退出登录"};
	
	private User user=null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system_set);
		AgentApplication.addActivity(SystemSetActivity.this);
		
		listview_set=(ListView) findViewById(R.id.listview_set);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(SystemSetActivity.this, android.R.layout.simple_list_item_1, setOption);
        listview_set.setAdapter(adapter);
		listview_set.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				switch(position) {
				case 0:
					if(!Current.isHadUser()) {
						Toast.makeText(SystemSetActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
						break;
					}
					user=Current.getUser();
					UserDao userdao=new UserDao(SystemSetActivity.this);
					LayoutInflater inflater = getLayoutInflater();
					final View layout = inflater.inflate(R.layout.dialog_changepassword, (ViewGroup)findViewById(R.id.dialog_changepassword));
					new AlertDialog.Builder(SystemSetActivity.this)
						.setTitle("密码修改")
						.setView(layout)
						.setPositiveButton("确定", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								EditText oldpwd=(EditText)layout.findViewById(R.id.edittext_oldpwd);
								EditText newpwd=(EditText)layout.findViewById(R.id.edittext_newpwd);
								String op=oldpwd.getText().toString();
								String np=newpwd.getText().toString();
								if(op.equals("")||np.equals("")) {
									Toast.makeText(SystemSetActivity.this, "请重新输入", Toast.LENGTH_SHORT).show();
								}
								else {
									UserDao userdao=new UserDao(SystemSetActivity.this);
									if(userdao.validateLogin(user.getUserName(), op)) {
										userdao.changePassword(user, np);
										Toast.makeText(SystemSetActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
									}
									else {
										Toast.makeText(SystemSetActivity.this, "旧密码不正确", Toast.LENGTH_SHORT).show();
									}
								}
							}
						})
				      	.setNegativeButton("取消", null)
				      	.show();
					break;
				case 1:
					if(!Current.isHadUser()) {
						Toast.makeText(SystemSetActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
						break;
					}
					Current.setUser(null);
					Current.setHadUser(false);
					Toast.makeText(SystemSetActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
					startActivity(new Intent(SystemSetActivity.this,MainActivity.class));
					break;
				}
			}
		});
		
	}

}
