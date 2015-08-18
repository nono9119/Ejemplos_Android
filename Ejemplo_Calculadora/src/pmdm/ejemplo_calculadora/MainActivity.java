package pmdm.ejemplo_calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.*;

public class MainActivity extends Activity 
{
	//Calculadora
	private double a;
	private double b;
	private EditText opA;
	private EditText opB;
	private TextView resultado;
	
	// Necesarias para el menu
	private View vw; 
	private String info = "Realizado por Antonio Martínez";
	private MenuInflater inflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// asignacion y registro del View para el menu
		vw = (ImageView) findViewById(R.id.img1);
		registerForContextMenu(vw);
		
		this.opA = (EditText)findViewById(R.id.op_a);
		this.opB = (EditText)findViewById(R.id.op_b);
		this.resultado = (TextView)findViewById(R.id.resultado);
	}


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) 
	{
		/****************************************************************
		* Evento encargado de construir los menus contextuales asociados 
		* a los diferentes controles de la aplicación
		*****************************************************************/
		super.onCreateContextMenu(menu, v, menuInfo);
		inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_ctx_img, menu);
	}

	
	@Override
	public boolean onContextItemSelected(MenuItem item) 
	{
		/******************************************************* 
		* Se crea el switch para controlar las acciones que se 
		* produciran dependiento de la opcion escogida
		********************************************************/
		switch(item.getItemId())
		{
			case R.id.inf:
				Toast.makeText(this, info, Toast.LENGTH_LONG).show();
				return true;
			case R.id.volver:
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}

	}

	/********************************
	* Metodos para las operaciones 
	*********************************/
	public void sumar(View vw)
	{
		if (this.opA.getText().toString().length() > 0 && 
				this.opB.getText().toString().length() > 0)
		{
			a = Double.parseDouble(this.opA.getText().toString());
			b = Double.parseDouble(this.opB.getText().toString());
			
			resultado.setText(Double.toString(this.a + this.b));
		}
	}
	
	public void restar(View vw)
	{
		if (this.opA.getText().toString().length() > 0 && 
				this.opB.getText().toString().length() > 0)
		{
			a = Double.parseDouble(this.opA.getText().toString());
			b = Double.parseDouble(this.opB.getText().toString());
			
			resultado.setText(Double.toString(this.a - this.b));
		}
	}
	
	public void multiplicar(View vw)
	{
		if (this.opA.getText().toString().length() > 0 && 
				this.opB.getText().toString().length() > 0)
		{
			a = Double.parseDouble(this.opA.getText().toString());
			b = Double.parseDouble(this.opB.getText().toString());
			
			resultado.setText(Double.toString(this.a * this.b));
		}
	}
	
	public void dividir(View vw)
	{
		if (Integer.parseInt(this.opB.getText().toString()) != 0)
		{
			if (this.opA.getText().toString().length() > 0 && 
					this.opB.getText().toString().length() > 0)
			{
				a = Double.parseDouble(this.opA.getText().toString());
				b = Double.parseDouble(this.opB.getText().toString());
				
				resultado.setText(Double.toString(this.a / this.b));
			}
		}
		else
		{
			resultado.setText("No se puede dividir entre cero.");
		}
		
	}
}
