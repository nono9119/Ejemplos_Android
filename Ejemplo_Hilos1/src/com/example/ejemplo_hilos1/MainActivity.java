package com.example.ejemplo_hilos1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnSinHilos;
	private Button btnHilo;
	private Button btnAsyncTask;
	private Button btnCancelar;
	private Button btnAsyncDialog;

	private ProgressBar pbarProgreso;
	private ProgressDialog pDialog;
	
	private ClaseAsyncTask cat;
	private ClaseAsyncTaskDialog catD;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSinHilos = (Button) findViewById(R.id.btnSinHilos);
		btnHilo = (Button) findViewById(R.id.btnHilo);
		btnAsyncTask = (Button) findViewById(R.id.btnAsyncTask);
		btnAsyncDialog = (Button) findViewById(R.id.btnAsyncDialog);
		btnCancelar = (Button) findViewById(R.id.btnCancelar);
		pbarProgreso = (ProgressBar) findViewById(R.id.pbarProgreso);
		
		
		// EJEMPLO SIN HILOS
		btnSinHilos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				pbarProgreso.setMax(100);
				pbarProgreso.setProgress(0);
				
				for (int i = 1; i <= 10; i++) {
					tareaLarga();
					pbarProgreso.incrementProgressBy(10);
				}
				
				Toast.makeText(MainActivity.this, "Tarea finalizada!",
		                Toast.LENGTH_SHORT).show();
			}
		});
		
		// EJEMPLO CON LA CLASE THREAD
		btnHilo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						pbarProgreso.post(new Runnable() {
							@Override
							public void run() {
								pbarProgreso.setProgress(0);
							}
						});
						for (int i = 1; i <= 10; i++) {
							tareaLarga();
							/*
							 *  EL METODO POST PERMITE MANEJAR LOS CONTROLES 
							 *  DE NUESTRA INTERFAZ
							 */
							pbarProgreso.post(new Runnable() {
								@Override
								public void run() {
									pbarProgreso.incrementProgressBy(10);
								}
							});
						}

						runOnUiThread(new Runnable() {
							/*
							 *  PERMITE "ENVIAR" OPERACIONES AL HILO PRINCIPAL(non-Javadoc)
							 * 	DESDE EL HILO SECUNDARIO
							 */
							public void run() {
								Toast.makeText(MainActivity.this, "Tarea finalizada!", 
										Toast.LENGTH_SHORT).show();
							}
						});
					}
				}).start();
			}
		});
	
		// EJEMPLO CON CLASE AUXILIAR
		btnAsyncTask.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cat = new ClaseAsyncTask();
				cat.execute();
			}
		});
	
		btnCancelar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cat.cancel(true);
			}
		});
	
		btnAsyncDialog.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				pDialog = new ProgressDialog(MainActivity.this);
				pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				pDialog.setMessage("Procesando...");
				pDialog.setCancelable(true);
				pDialog.setMax(100);
				
				catD = new ClaseAsyncTaskDialog();
				catD.execute();
			}
		});
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	*/

	// METODO PARA SIMULAR UNA TAREA DE LARGA DURACION
	public static void tareaLarga() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
	
	// CLASE AUXILIAR AsyncTask PARA LOS HILOS
	private class ClaseAsyncTask extends AsyncTask<Void, Integer, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			for (int i = 1; i <= 10; i++) {
				MainActivity.tareaLarga();
				publishProgress(i*10);
				if (isCancelled()) {
					break;
				}
			}
			return true;
		}
			
		@Override
		protected void onProgressUpdate(Integer... values) {
			int progreso = values[0].intValue();
			
			pbarProgreso.setProgress(progreso);
		}
		
		@Override
		protected void onPreExecute() {
			pbarProgreso.setMax(100);
			pbarProgreso.setProgress(0);
		}
			
		@Override
		protected void onPostExecute(Boolean result) {
			if (result) {
				Toast.makeText(MainActivity.this, "Tarea finalizada!",
						Toast.LENGTH_SHORT).show();
			}
		}
			 
		@Override
		protected void onCancelled() {
			Toast.makeText(MainActivity.this, "Tarea cancelada!",
					Toast.LENGTH_SHORT).show();
		}
	}

	// CLASE AUXILIAR AsyncTask y Dialog PARA LOS HILOS
	private class ClaseAsyncTaskDialog extends AsyncTask<Void, Integer, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			for (int i = 1; i <= 10; i++) {
				MainActivity.tareaLarga();
				publishProgress(i*10);
				if (isCancelled()) {
					break;
				}
			}
			return true;
		}
			
		@Override
		protected void onProgressUpdate(Integer... values) {
			int progreso = values[0].intValue();
			
			pbarProgreso.setProgress(progreso);
		}
		
		@Override
		protected void onPreExecute() {
			pDialog.setOnCancelListener(new OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					ClaseAsyncTaskDialog.this.cancel(true);
					
				}
			});
			
			pDialog.setProgress(0);
			pDialog.show();
		}
			
		@Override
		protected void onPostExecute(Boolean result) {
			if (result) {
				pDialog.dismiss();
				Toast.makeText(MainActivity.this, "Tarea finalizada!",
						Toast.LENGTH_SHORT).show();
			}
		}
			 
		@Override
		protected void onCancelled() {
			Toast.makeText(MainActivity.this, "Tarea cancelada!",
					Toast.LENGTH_SHORT).show();
		}
		
	}
}
