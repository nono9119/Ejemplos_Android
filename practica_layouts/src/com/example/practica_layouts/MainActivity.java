package com.example.practica_layouts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.example.practica_layouts.R;

public class MainActivity extends Activity 
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void cmdButtonClick(View v)
	{
		Intent intent;
		
		switch (v.getId())
		{
			case R.id.cmdFrame:
				intent = new Intent(this, Frame.class);
				this.startActivity(intent);
				break;
			case R.id.cmdGrid:
				intent = new Intent(this, Grid.class);
				this.startActivity(intent);
				break;
			case R.id.cmdLinear:
				intent = new Intent(this, Linear.class);
				this.startActivity(intent);
				break;
			case R.id.cmdRelative: 
				intent = new Intent(this, Relative.class);
				this.startActivity(intent);
				break;
			case R.id.cmdTable:
				intent = new Intent(this, Table.class);
				this.startActivity(intent);
				break;
		}
	}

}
