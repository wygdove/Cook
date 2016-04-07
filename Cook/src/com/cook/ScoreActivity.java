package com.cook;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class ScoreActivity extends Activity{

	private RatingBar ratingBar;
    private SharedPreferences sharedpre;
    private SharedPreferences.Editor editor;
    
    private float score;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		AgentApplication.addActivity(ScoreActivity.this);

		ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		
		sharedpre=getSharedPreferences("ScoreActivity", Activity.MODE_PRIVATE);
        editor=sharedpre.edit();
        score=sharedpre.getFloat("score",0.0f);
        ratingBar.setRating(score);

	    ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				score = ratingBar.getRating();
		        editor.putFloat("score",score);
		        editor.commit();
				String sco = "您的评分为"+Float.toString(score)+",感谢您的评价";
				Toast.makeText(ScoreActivity.this, sco, Toast.LENGTH_SHORT).show();
			}
		});
	}

}
