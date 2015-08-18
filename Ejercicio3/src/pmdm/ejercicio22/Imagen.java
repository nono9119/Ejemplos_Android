package pmdm.ejercicio22;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Imagen extends Activity{
	Context ctx = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagen);
		
		ctx = this;
		
		View vw = this.findViewById(R.id.imageView1);
		registerForContextMenu(vw);
		
		Button btn = (Button) this.findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}
	
	// Menu contextual
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.imgmenu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId())
		{
			case R.id.info:
				Toast.makeText(this, "Imagen para el examen", Toast.LENGTH_LONG).show();
				return true;
			default:
				return super.onContextItemSelected(item);
		}
	}
	
	public void cmdCerrar() {
		finish();
	}
}
