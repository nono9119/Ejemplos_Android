package com.example.practica_widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
	}
	
    public void volver(View view) {
    	finish();
    }   
}
