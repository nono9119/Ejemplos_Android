package com.acelerometro;

import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.pm.ActivityInfo;

public class MainActivity extends Activity implements SensorEventListener {
	private Sensor ssr;
	private TextView x;
	private TextView y;
	private TextView z;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		x = (TextView)findViewById(R.id.xID);
		y = (TextView)findViewById(R.id.yID);
		z = (TextView)findViewById(R.id.zID);
		// PARA QUE SE VEA SOLO VERTICALMENTE
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
	}

	// CUANDO SE INICIA LA APLICACION O VUELVE DESPUES DE UNA PAUSA
	protected void onResume() {
		super.onResume();
		// ADMINISTRADOR DE LOS SENSORES
		// OBTIENE DEL S.O EL SERVICIO DE SENSORES
		SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		// ENLISTAR LOS SENSORES QUE SEAN DEL TIPO ACELEROMETRO
		List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
		if (sensors.size() > 0) {
			// SI EL DISPOSITIVO ANDROID TIENE ACELEROMETRO
			sm.registerListener(this, sensors.get(0), SensorManager.SENSOR_DELAY_GAME);
		}
	}

	// EN PAUSA Y STOP LO QUE SE HACE ES DEJAR DE RECIBIR LOS INPUTS
	protected void onPause() {
		SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		sm.unregisterListener(this, ssr);
		super.onPause();
	}

	protected void onStop() {
		SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		sm.unregisterListener(this, ssr);
		super.onStop();
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		float xValue = event.values[0];
		float yValue = event.values[1];
		float zValue = event.values[2];
		
		this.x.setText("X = " + xValue);
		this.y.setText("Y = " + yValue);
		this.z.setText("Z = " + zValue);
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}
