package pmdm.ejemplo_adaptadores;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

public class ListaModActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista);
		
		ListView lv = (ListView) this.findViewById(R.id.lstLista);
		
		ListaModAdapter adaptador = new ListaModAdapter(this);
		lv.setAdapter(adaptador);
		
		OnItemClickListener mMessageClickedHandler = new OnItemClickListener()
		{
			@SuppressWarnings("rawtypes")
			public void onItemClick(AdapterView parent, View v, int position, long id)
			{
				Toast.makeText(getApplicationContext(), "Click en la posición "+position,
						Toast.LENGTH_SHORT).show();
			}
		};
		
		lv.setOnItemClickListener(mMessageClickedHandler);
	}
	
}
