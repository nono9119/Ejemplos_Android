package pmdm.ejemplo_calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class NotificacionActividad extends Activity {
	private double c;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// RECOGER DATOS DE LA ACTIVIDAD PRINCIPAL
		Bundle bd = getIntent().getExtras();
		c = bd.getDouble("resultado");
		// MOSTRAR EL RESULTADO 
		Toast.makeText(this, "Resultado:  " + c, Toast.LENGTH_LONG).show();
		finish();
	}
}
