package pmdm.ejercicio1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.EditText;

public class Main extends Activity {

	String nmb = "";
	String apll = "";
	EditText etNombre = null;
	EditText etApellido = null;
	Bundle bd = null;
	Context ctx = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ctx = this;
		bd = new Bundle();
		etNombre = (EditText)findViewById(R.id.editText1);
		etApellido = (EditText)findViewById(R.id.editText2);
		
	}

	

}
