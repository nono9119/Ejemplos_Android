package com.example.practica_layouts;

import com.example.practica_layouts.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Grid extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);
	}
	
	public void cmdVolver(View v)
	{
		finish();
	}
}
