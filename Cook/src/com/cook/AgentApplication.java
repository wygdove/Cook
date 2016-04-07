package com.cook;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class AgentApplication extends Application  {

	private static List<Activity> activities=new ArrayList<Activity>();
	
	public static void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
		for(Activity activity : activities) {
			activity.finish();
		}
//		onDestroy();
		System.exit(0);
	}
	
}