package com.pmdm.ejemplopreferencias;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch(item.getItemId()) {
			case R.id.mnuPro1:
				intent = new Intent(this, PrefsActivity.class);
				startActivity(intent);
				break;
			case R.id.mnuPro2:
				intent = new Intent(this, FileActivity.class);
				startActivity(intent);
				break;
			case R.id.mnuFin:
				SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
				String valor = settings.getString("Valor", "default");
				Toast.makeText(this, "Preferencias "+valor, Toast.LENGTH_SHORT).show();
				finish();
				break;
			default:
				return super.onOptionsItemSelected(item);
		}
		return true;
	}
}
