package com.example.ejemplobotones;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	Context ctx = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		ctx = this;
		
		setContentView(R.layout.main);
		
		//con un listener en una clase anónima
		Button btn = (Button) this.findViewById(R.id.cmdTres);
		btn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(ctx, "Pulsado boton Tres", Toast.LENGTH_SHORT).show();
			}
		});
	}

	// metodo que llamara al SSOO cuando se haga click en el segundo boton
	public void cmdDos_click(View v)
	{
		Toast.makeText(ctx, "Pulsado boton Dos", Toast.LENGTH_SHORT).show();
	}

}
