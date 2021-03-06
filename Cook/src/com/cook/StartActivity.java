package com.cook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.cook.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class StartActivity extends Activity {

	private ImageView welcomeImg = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		AgentApplication.addActivity(StartActivity.this);

		welcomeImg = (ImageView) this.findViewById(R.id.welcome_img);
		AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
		anima.setDuration(3000);
		welcomeImg.startAnimation(anima);
		anima.setAnimationListener(new AnimationImpl());
		copyDB("cook.db");
	}
	
	private void copyDB(final String dbname) {
		new Thread() {
			public void run() {
				File file = new File(getFilesDir(), dbname);
				if (file.exists() && file.length() > 0) {
					//System.out.println("已经拷贝过了数据库,无需重新拷贝");
				} else {
					try {
						InputStream is = getAssets().open(dbname);
						byte[] buffer = new byte[1024];
						FileOutputStream fos = new FileOutputStream(file);
						int len = -1;
						while ((len = is.read(buffer)) != -1) {
							fos.write(buffer, 0, len);
						}
						fos.close();
						is.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}

	private class AnimationImpl implements AnimationListener {

		@Override
		public void onAnimationStart(Animation animation) {
			welcomeImg.setBackgroundResource(R.drawable.fanwan);
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			skip();
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
		}

	}

	private void skip() {
		startActivity(new Intent(this, MainActivity.class));
//		startActivity(new Intent(this, TestActivity.class));
		finish();
	}

}