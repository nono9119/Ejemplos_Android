package pmdm.ejemplo_t10menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View vw = this.findViewById(R.id.imgUno);
		registerForContextMenu(vw);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainopt, menu);
		return true;
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) 
	{
		switch (item.getItemId())
		{
			case R.id.mnuNombre:
				Toast.makeText(this, "Img1.png", Toast.LENGTH_LONG).show();
				return true;
			default:
				return super.onContextItemSelected(item);
		}
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) 
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainctx, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId())
		{
			case R.id.mnuOpen:
				Intent intent = new Intent(this, OtherActivity.class);
				startActivity(intent);
				return true;
			case R.id.mnuAbout:
				Toast.makeText(this, "Practica de Android", Toast.LENGTH_LONG).show();
				return true;
			case R.id.mnuFin:
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
		
	}
}
