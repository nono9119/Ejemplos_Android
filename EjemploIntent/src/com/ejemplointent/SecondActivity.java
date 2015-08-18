package com.ejemplointent;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		TextView mTV;
		int value = -1;
		String txt = "";
		Uri mUri;
		Bundle mBundle;
		Intent mIntent;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		mIntent = getIntent(); // CONSEGUIMOS EL INTENT QUE HA LANZADO LA ACTIVIDAD
		if (mIntent != null) {
			mBundle = mIntent.getExtras();
			if (mBundle != null) {
				value = mBundle.getInt("intValue", value); // PUEDE SER QUE DE ERROR
			} else {
				value = -1;
			}
			
			mUri = mIntent.getData();
			if (mUri == null) {
				txt = "txt";
			} else {
				txt = mUri.toString();
			}
		}
		
		mTV = (TextView) findViewById(R.id.txtNum);
		mTV.setText(String.valueOf(value));
		
		mTV = (TextView) findViewById(R.id.txtText);
		mTV.setText(String.valueOf(txt));
	}

	
}
