package com.ejemplo_bbdd;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText txtNombre;
	private EditText txtValor;
	private WrapBBDD BBDD;
	private int posBBDD = 0;
	private Cursor dataBBDD;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtNombre = (EditText)this.findViewById(R.id.txtNombre);
		txtValor = (EditText)this.findViewById(R.id.txtValor);
		BBDD = new WrapBBDD(this);
		posBBDD = 0;
	}
	
	public void onResume() {
		super.onResume();
		dataBBDD = BBDD.getReadableDatabase().rawQuery(
				"SELECT * FROM "+ WrapBBDD.BBDD_TABLA_VALORES+" ORDER BY "+WrapBBDD.TITULO, null);
		SharedPreferences sp = this.getPreferences(MODE_PRIVATE);
		posBBDD = sp.getInt("posBBDD", 0);
		dataBBDD.moveToPosition(posBBDD);
		txtNombre.setText(dataBBDD.getString(1));
		txtValor.setText(dataBBDD.getString(2));
	}

	public void onPause() {
		if (dataBBDD != null) {
			dataBBDD.close();
		}
		SharedPreferences sp = this.getPreferences(MODE_PRIVATE);
		sp.edit().putInt("posBBDD", posBBDD).commit();
		super.onPause();
	}
	
	public void cmdBtn(View btn) {
		switch (btn.getId()) {
			case R.id.cmdPrev:
				dataBBDD.moveToPrevious();
				if (!dataBBDD.isBeforeFirst()) {
					posBBDD--;
					txtNombre.setText(dataBBDD.getString(1));
					txtValor.setText(dataBBDD.getString(2));
				} else {
					dataBBDD.moveToNext();
				}
			break;
			case R.id.cmdNext:
				dataBBDD.moveToNext();
				if (!dataBBDD.isAfterLast()) {
					posBBDD++;
					txtNombre.setText(dataBBDD.getString(1));
					txtValor.setText(dataBBDD.getString(2));
				} else {
					dataBBDD.moveToPrevious();
				}
			break;
		}
	}

}
