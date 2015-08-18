package pmdm.ejemplo_adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void cmdButtonClick(View v)
	{
		Intent intent;
		
		switch (v.getId())
		{
			case R.id.cmdLista:
				intent = new Intent(this, ListaActivity.class);
				startActivity(intent);
				break;
			case R.id.cmdListaMod:
				intent = new Intent(this, ListaModActivity.class);
				startActivity(intent);
				break;
			case R.id.cmdGaleria:
				intent = new Intent(this, GaleriaActivity.class);
				startActivity(intent);
				break;
			case R.id.cmdSpinner:
				intent = new Intent(this, SpinnerActivity.class);
				startActivity(intent);
				break;
			case R.id.cmdListaExpansible:
				intent = new Intent(this, ListaExpansibleActivity.class);
				startActivity(intent);
				break;
		}
	}

	
}
