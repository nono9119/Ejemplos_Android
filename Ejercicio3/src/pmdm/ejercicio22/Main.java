package pmdm.ejercicio22;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;

public class Main extends Activity {
	Context ctx = null;
	Intent intent = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ctx = this;
		
		ListView lv = (ListView)this.findViewById(R.id.lstOpciones);
		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(
				this, R.array.lista, android.R.layout.simple_list_item_1);
		
		lv.setAdapter(adaptador);
		
		OnItemClickListener mMessageClickedHandler = new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
					case 0:
						Toast.makeText(ctx,"Saludos",Toast.LENGTH_LONG).show();
						break;
					case 1:
						intent = new Intent(ctx, Tabla.class);
						startActivity(intent);
						break;
					case 2:
						intent = new Intent(ctx, Imagen.class);
						startActivity(intent);
						break;
					case 3: 
						mtdSalir();
						break;
				}
			}
		};
		lv.setOnItemClickListener(mMessageClickedHandler);
	}

	// Menu no contextual
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mnunctx, menu);
		return true;
	}
		
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.mnuAcerca:
				Toast.makeText(this, "Realizado por Antonio Martinez", Toast.LENGTH_LONG).show();
				return true;
			case R.id.mnuCerrar:
				finish();
					return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	public void mtdSalir() {
		finish();
	}
}
