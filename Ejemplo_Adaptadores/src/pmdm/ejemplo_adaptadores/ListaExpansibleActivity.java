package pmdm.ejemplo_adaptadores;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;
import android.view.View;

public class ListaExpansibleActivity extends Activity
{
	private ArrayList<String> grupos;
	private ArrayList<ArrayList<ArrayList<String>>> hijos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listaexpandible);
		cargarDatos();
		ExpandableListView lv = (ExpandableListView) this.findViewById(R.id.lstLista);
		// nuestro adaptador
		ListaExpansibleAdapter adaptador = new ListaExpansibleAdapter(this, grupos, hijos);
		lv.setAdapter(adaptador);
		// eventos de click en el grupo y en un hijo del grupo
		lv.setOnGroupClickListener(new OnGroupClickListener()
		{
			@Override
			public boolean onGroupClick(ExpandableListView arg0, View arg1, int groupPosition, long arg3)
			{
				Toast.makeText(getApplicationContext(), 
						"Click en el grupo "+groupPosition, Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		
		lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() 
		{
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
					int childPosition, long id) 
			{
				Toast.makeText(getApplicationContext(), "Click en el grupo"+groupPosition+" Hijo "+childPosition, 
						Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		
	}
	
	public void cargarDatos()
	{
		grupos = new ArrayList<String>();
		hijos = new ArrayList<ArrayList<ArrayList<String>>>();
		
		grupos.add("Grupo 1");
		grupos.add("Grupo 2");
		grupos.add("Grupo 3");
		
		hijos.add(new ArrayList<ArrayList<String>>());
		hijos.get(0).add(new ArrayList<String>());
		hijos.get(0).get(0).add("Hijo 1 grupo 1");
		hijos.get(0).add(new ArrayList<String>());
		hijos.get(0).get(1).add("Hijo 2 grupo 1");
		hijos.get(0).add(new ArrayList<String>());
		hijos.get(0).get(2).add("Hijo 3 grupo 1");
		
		hijos.add(new ArrayList<ArrayList<String>>());
		hijos.get(1).add(new ArrayList<String>());
		hijos.get(1).get(0).add("Hijo 1 grupo 2");
		hijos.get(1).add(new ArrayList<String>());
		hijos.get(1).get(1).add("Hijo 2 grupo 2");
		hijos.get(1).add(new ArrayList<String>());
		hijos.get(1).get(2).add("Hijo 3 grupo 2");
		
		hijos.add(new ArrayList<ArrayList<String>>());
		hijos.get(2).add(new ArrayList<String>());
		hijos.get(2).get(0).add("Hijo 1 grupo 3");
		hijos.get(2).add(new ArrayList<String>());
		hijos.get(2).get(1).add("Hijo 2 grupo 3");
		hijos.get(2).add(new ArrayList<String>());
		hijos.get(2).get(2).add("Hijo 3 grupo 3");
	}
	
}
