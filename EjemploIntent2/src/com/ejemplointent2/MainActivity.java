package com.ejemplointent2;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClic(View v) {
		Intent mIntent = new Intent();
		Bundle mBundle = new Bundle();
		int value = 2;
		
		switch(v.getId()) {
			case R.id.Button01: // UTILIZA LOS EXTRAS Y DATA
				mIntent.setAction("com.ejemplointent.ACCDOS");
				mBundle.putInt("intValue", value);
				mIntent.putExtras(mBundle);
				mIntent.setDataAndType(Uri.parse("Texto Second"), "text/plain");
				startActivity(mIntent);
				break;
			case R.id.Button02: // UTILIZA LOS EXTRAS
				mIntent.setAction("com.ejemplointent.ACCDOS");
				mBundle.putInt("intValue", value);
				mIntent.putExtras(mBundle);
				startActivity(mIntent);
				break;
			case R.id.Button03:
				mIntent.setAction("com.ejemplointent.ACCDOS");
				startActivity(mIntent);
				break;
		}
	}
}
