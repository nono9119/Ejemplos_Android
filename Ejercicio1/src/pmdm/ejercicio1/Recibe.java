package pmdm.ejercicio1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Recibe extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recibe);
		
		TextView tv1 = (TextView)findViewById(R.id.textView3);
		TextView tv2 = (TextView)findViewById(R.id.textView4);
	
		tv1.setText(savedInstanceState.getString("NOMBRE"));
		tv2.setText(savedInstanceState.getString("APELLIDOS"));
		
	}
}
