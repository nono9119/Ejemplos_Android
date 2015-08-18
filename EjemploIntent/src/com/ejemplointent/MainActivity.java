package com.ejemplointent;

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
		Intent mIntent;
		int value = 1;
		
		switch(v.getId()) {
			case R.id.cmdOpen:
				Bundle bnd = new Bundle();
				mIntent = new Intent(this, SecondActivity.class); // TIPO EXPLICITO
				
				bnd.putInt("intValue", value); // PARAMETRO PARA LA SEGUNDA ACTIVIDAD
				mIntent.putExtras(bnd);
				mIntent.setData(Uri.parse("Texto")); // DATOS EXTRA PARA LA SEGUNDA ACTIVIDAD
				startActivity(mIntent);
				break;
			case R.id.cmdBrowser:
				mIntent = new Intent();
				mIntent.setAction(Intent.ACTION_VIEW); // ACCION EXTERNA, ABRIRA EL NAVEGADOR
				mIntent.setData(Uri.parse("http://www.boe.es")); // URL A ABRIR
				startActivity(mIntent);
				break;
		}
	}
}
