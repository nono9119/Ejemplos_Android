package pmdm.ejemplo_notificaciones;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class NotificacionActividad extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(this, "Notificacion recibida", Toast.LENGTH_LONG).show();
		finish();
	}
}
