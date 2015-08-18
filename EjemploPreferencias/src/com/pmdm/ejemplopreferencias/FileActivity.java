package com.pmdm.ejemplopreferencias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		FileInputStream fis = null;
		File dir = null;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fileactivity);
		
		// NOMBRE DEL FICHERO
		String nomFile = ((TextView) findViewById(R.id.txtFichero)).getText().toString();
		// ESTADO DE LA SD
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			// NUESTRO FICHERO AL DIRECTORIO PUBLICO DE DOWNLOADS
			dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			File file = new File(dir, nomFile);
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException fnfe) {
				Toast.makeText(this, "Fichero no existe en externo", Toast.LENGTH_SHORT);
				return;
			}
		} else {
			try {
				fis = openFileInput(nomFile);
			} catch (FileNotFoundException e) {
				Toast.makeText(this, "Fichero no existe en interno", Toast.LENGTH_SHORT);
				return;
			}
		}
		
		// UNA VEZ ABIERTO INTERNO O EXTERNO LEEMOS LOS DATOS DEL FICHERO
		byte []buffer;
		try {
			buffer = new byte[fis.available()];
		} catch (IOException e) {
			Toast.makeText(this, "Error de lectura del tamaño del fichero", Toast.LENGTH_SHORT);
			buffer = new byte[255];
		}
		
		// LEER LOS DATOS Y LIBERAR ESTRUCTURAS
		try {
			fis.read(buffer);
			fis.close();
		} catch (IOException e) {
			Toast.makeText(this, "Error de lectura", Toast.LENGTH_SHORT);
			return;
		}

		// MOSTRAMOS LOS DATOS EN PANTALLA
		String data = new String(buffer);
		((TextView) findViewById(R.id.txtDatos)).setText(data);
	}
	

	public void cmdGrabar_Click(View v) {
		FileOutputStream fos = null;
		String val = ((TextView)findViewById(R.id.txtDatos)).getText().toString();
		String nomFile = ((TextView)findViewById(R.id.txtFichero)).getText().toString();
		String state = Environment.getExternalStorageState(); 
				
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			// NUESTRO FICHERO AL DIRECTORIO PUBLICO DE DOWNLOADS
			File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			File file = new File(dir, nomFile);
			try {
				fos = new FileOutputStream(file);
			} catch (FileNotFoundException fnfe) {
				Toast.makeText(this, "Error al crear el fichero en externo", Toast.LENGTH_SHORT);
				return;
			}
		} else {
			try {
				fos = openFileOutput(nomFile, Context.MODE_PRIVATE);
			} catch (FileNotFoundException e) {
				Toast.makeText(this, "Error al crear el fichero interno", Toast.LENGTH_SHORT);
				return;
			} 
		}
		
		try {
			fos.write(val.getBytes());
			fos.close();
		} catch (IOException e) {
			Toast.makeText(this, "Error al escribir", Toast.LENGTH_SHORT);
			return;
		}


	}

}
