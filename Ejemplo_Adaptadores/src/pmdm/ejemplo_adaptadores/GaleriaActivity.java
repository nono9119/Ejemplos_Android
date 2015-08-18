package pmdm.ejemplo_adaptadores;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;

public class GaleriaActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.galeria);
		
		Gallery gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new GaleriaAdapter(this)); //nuestro adaptador
		gallery.setSelection(3); // nos posiciones en el medio de las imagenes
		
		gallery.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id)
			{
				Toast.makeText(GaleriaActivity.this, ""+position, Toast.LENGTH_SHORT).show();
			}
		});
		
	}
	
}
