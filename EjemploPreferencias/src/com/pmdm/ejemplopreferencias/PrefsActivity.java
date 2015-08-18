package com.pmdm.ejemplopreferencias;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.EditText;

public class PrefsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prefsactivity);
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
		String valor = settings.getString("Valor", "default");
		EditText val = (EditText) this.findViewById(R.id.txtValor);
		val.setText(valor);
	}

	@Override
	protected void onStop() {
		super.onStop();
		EditText val = (EditText) this.findViewById(R.id.txtValor);
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("Valor", val.getText().toString());
		editor.commit();
	}

}
