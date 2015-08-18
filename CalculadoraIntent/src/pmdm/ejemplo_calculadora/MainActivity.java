package pmdm.ejemplo_calculadora;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.*;


public class MainActivity extends Activity 
{
	private double a;
	private double b;
	
	private EditText opA;
	private EditText opB;
	
	private TextView resultado;
	
	final static public int ID_DLG_1 = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.opA = (EditText)findViewById(R.id.op_a);
		this.opB = (EditText)findViewById(R.id.op_b);
		this.resultado = (TextView)findViewById(R.id.resultado);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override 
	public boolean onOptionsItemSelected(MenuItem mi) {
		switch(mi.getItemId()) {
			case R.id.inf:
				Toast.makeText(this, "Menú creado el 30/1", Toast.LENGTH_SHORT).show();
				break;
			case R.id.salir:
				showDialog(ID_DLG_1);
				break;
		}
		return true;
	}

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
	
	public void navegar(View v) {
		Intent mIntent;
		
		if (v.getId() == R.id.navegar) {
			mIntent = new Intent();
			mIntent.setAction(Intent.ACTION_VIEW);
			mIntent.setData(Uri.parse("http://www.google.es"));
			startActivity(mIntent);
		}
	}
	
	public AlertDialog onCreateDialog(int id) {
		AlertDialog alert = null;
		AlertDialog.Builder adb = new AlertDialog.Builder(this);
		adb.setMessage("¿Quiere salir?");
		adb.setCancelable(false);
		adb.setPositiveButton("Si", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				//Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
		adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				//Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
			}
		});
		alert = adb.create();
		return alert;

	}
}
