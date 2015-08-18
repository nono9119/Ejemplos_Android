package com.example.ejemplo_actividad2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private int valor = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        //recuperamos la configuracion guardada por nosotros
        miConfiguracion datos = (miConfiguracion)getLastNonConfigurationInstance();
        if (datos != null)
        {
        	valor = datos.getVal();
        }
        else
        {
        	//Siempre entra aqui
        	valor = -5;
        }
        
        setContentView(R.layout.main);
    }


    public void cmdMostrarClick(View v)
    {
    	Toast.makeText(this, "Propiedad: "+valor, Toast.LENGTH_SHORT).show();
    	valor++;
    }
    
    @Override
    public Object onRetainNonConfigurationInstance()
    {
    	miConfiguracion datos = new miConfiguracion();
    	datos.setVal(valor); //guardamos el objeto deseado
    	return datos;
    }
    
}
