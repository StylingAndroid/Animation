package com.stylingandroid.Animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

public class FirstActivity extends Activity
{
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.first );
		final Button button = (Button)findViewById( R.id.NextButton );
		button.setOnClickListener( new OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				Animation animation = AnimationUtils.loadAnimation( FirstActivity.this, R.anim.fade_out );
				animation.setAnimationListener( new AnimationListener()
				{				
					@Override
					public void onAnimationStart( Animation animation ) {}
					
					@Override
					public void onAnimationRepeat( Animation animation ) {}
					
					@Override
					public void onAnimationEnd( Animation animation )
					{
						button.setVisibility( View.INVISIBLE );
						startActivity( new Intent( FirstActivity.this, SecondActivity.class ) );
						overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
					}
				} );
				button.startAnimation( animation );
			}
		});
	}
	
	@Override
	protected void onResume()
	{
		findViewById( R.id.NextButton ).setVisibility( View.VISIBLE );
		super.onResume();
	}
}
