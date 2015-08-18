package pmdm.ejercicio22;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Tabla extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabla);
	}
	
	public void cmdCerrar(View v) {
		finish();
	}

}
