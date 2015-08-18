package pmdm.ejercicio1;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class PasaBoton extends Button implements View.OnClickListener {

	Context ctx = null;
	
	public PasaBoton(Context context) {
		super(context);
		ctx = context;
		this.setOnClickListener(this); 
	}
	

	public PasaBoton(Context context, AttributeSet attr) {
		super(context, attr);
		ctx = context;
		this.setOnClickListener(this);
	}
	
	public PasaBoton(Context context, AttributeSet attr, int defaultStyles) {
		super(context, attr, defaultStyles);
		ctx = context;
		this.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(ctx, Recibe.class);
		Bundle bd = new Bundle();
		
		EditText nmb = (EditText)findViewById(R.id.editText1);
		EditText apl = (EditText)findViewById(R.id.editText2);
		String nombre = nmb.getText().toString();
		String apll = nmb.getText().toString();
		bd.putString("NOMBRE", nombre);
		bd.putString("APELLIDO", apll);
	}
}
