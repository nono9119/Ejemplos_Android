package com.example.ejemplo_actividad;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Details extends Activity
{
	EditText val1;
	EditText val2;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		
		Intent intent = getIntent(); // Cogemos el Intent que ha generado el lanzamiento
		
		int numLista = intent.getIntExtra(MainActivity.KEY_LIST,0); // Los datos que nos pasan
		
		//ponemos los datos en pantalla
		
		TextView txt = (TextView)this.findViewById(R.id.txtNombre);
		txt.setText(Datos.lista[numLista][0]);
		txt = (TextView)this.findViewById(R.id.txtAuthor);
		txt.setText(Datos.lista[numLista][1]);
		val1 = (EditText)this.findViewById(R.id.txtVal1);			
		val2 = (EditText)this.findViewById(R.id.txtVal2);
		
		// Gestionamos el boton de cerrar y devolver datos
		Button bt = (Button)this.findViewById(R.id.cmdVolver);
		bt.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0)
			{
				Intent intent = new Intent();
				// Devolvemos cada dato de una forma distinta
				intent.putExtra(MainActivity.KEY_RTN_VAL1,val1.getText().toString());
				intent.setData(Uri.parse(val2.getText().toString()));
				setResult(RESULT_OK,intent); // Resultado y datos a devolver
				finish(); // fin actividad
			}
		});

		
	}
}
