package com.example.ejemplo_actividad;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	public static String KEY_LIST = "numlist"; //Clave para acceder al parámetro para recrear
	public static String KEY_RTN_VAL1 = "valor1"; //Clave para lo devuelto por la actividad hija
	private static int COD_RTN_ACT = 0;
	Context ctx;
	int numLista = 0; //Elemento actual de la lista
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // El UI en el fichero main.xml
        ctx = this;
        
        if (savedInstanceState != null)
        {
        	// Estamos recreando la actividad, hay un Bundle de vuelta
        	numLista = savedInstanceState.getInt(KEY_LIST,0);
        }
        
        // Ponemos los datos en la lista
        ListView lv = (ListView)this.findViewById(R.id.lstLibros);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Datos.getNombres()));
        lv.setOnItemClickListener(new OnItemClickListener()
        {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        	{
        		// Nos quedamos con el ID pulsado para recrear
        		numLista = position; // la posicion es el indice del array
        		// Lanzar la otra actividad desde un intent
        		Intent intent = new Intent(ctx,Details.class);
        		intent.putExtra(KEY_LIST,numLista); // Mandamos el numero del libro a visualizar
        		startActivityForResult(intent,COD_RTN_ACT);
        	}
        });
        
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    */
    
    public void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
    	if (resultCode == RESULT_OK && requestCode == COD_RTN_ACT)
    	{
    		//cuando vuelva la actividad de forma correcta recogemos los valores y los mostramos
    		StringBuffer sb = new StringBuffer();
    		sb.append("De vuelta:\n");
    		sb.append("Valor 1:"+intent.getStringExtra(KEY_RTN_VAL1)+"\n");
    		sb.append("Valor 2:"+intent.getData().toString());
    		Toast.makeText(ctx,sb.toString(),Toast.LENGTH_LONG).show(); //mostramos en pantalla
    	}
    }
    
    public void onSaveInstanceState(Bundle outState)
    {
    	outState.putInt(KEY_LIST,numLista); //grabamos los datos para recrear la actividad
    }
    
}
