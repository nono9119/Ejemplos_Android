package ejemplos.practicatouch;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class EjemploTouch extends Activity implements OnTouchListener {
	private TextView txt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ejemplo_touch);
		txt = (TextView)findViewById(R.id.txtID); // REF. AL OBJETO DEL LAUOUT
		txt.setOnTouchListener(this); // SE LE ASIGNA EL EVENTO ONTOUCH
	}

	@Override
	public boolean onTouch(View v, MotionEvent m) {
		switch(m.getAction()) {
			case MotionEvent.ACTION_DOWN: // PRIMERA VEZ QUE SE TOCA LA PANTALLA
				txt.setText("Has activado el evento Touch al pulsar");
				break;
			case MotionEvent.ACTION_MOVE: // AL MOVER EL DEDO
				txt.setText("Has activado el evento Touch al mover el dedo");
				break;
			case MotionEvent.ACTION_UP: // AL QUITAR EL DEDO
				txt.setText("Has quitado el dedo");
				break;
		}
		return true;
	}

}
