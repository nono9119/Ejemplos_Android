package pmdm.ejemplo_calculadora;

import android.os.Bundle;
import android.app.Activity;
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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
