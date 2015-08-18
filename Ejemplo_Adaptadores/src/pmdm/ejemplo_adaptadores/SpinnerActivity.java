package pmdm.ejemplo_adaptadores;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;

public class SpinnerActivity extends Activity implements OnItemSelectedListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		
		Spinner lv = (Spinner)this.findViewById(R.id.lstSpinner);
		
		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(
				this, R.array.lista, android.R.layout.simple_spinner_dropdown_item);
		
		lv.setAdapter(adaptador);
		
		lv.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int it,
			long lg) 
	{
		Toast.makeText(getApplicationContext(), "Click en la posición "+it, Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0)
	{
		// TODO Auto-generated method stub
	}
	
	
}
