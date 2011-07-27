package com.stylingandroid.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

public class SecondActivity extends Activity
{
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.second );
		final Button button = (Button)findViewById( R.id.BackButton );
		button.setOnClickListener( new OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				Animation animation = AnimationUtils.loadAnimation( SecondActivity.this, R.anim.grow_spin );
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
						goBack();
					}
				} );
				button.startAnimation( animation );
			}
		});
	}

	@Override
	protected void onResume()
	{
		findViewById( R.id.BackButton ).setVisibility( View.VISIBLE );
		super.onResume();
	}

	private void goBack()
	{
		finish();
		overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
	}

	@Override
	public boolean onKeyUp( int keyCode, KeyEvent event )
	{
		if( keyCode == KeyEvent.KEYCODE_BACK )
		{
			goBack();
			return true;
		}
		return super.onKeyUp( keyCode, event );
	}
}
