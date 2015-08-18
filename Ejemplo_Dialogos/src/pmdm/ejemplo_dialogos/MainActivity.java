package pmdm.ejemplo_dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {
	final static public int ID_DLG_1 = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	// PRIMER DIALOGO
	public void cmdDlg1_Click(View v) {
		showDialog(ID_DLG_1); // MOSTRAR DIALOGO CON ID=1
		
	}
	
	@Override
	public AlertDialog onCreateDialog(int id) {
		switch(id) {
			case ID_DLG_1: // EN CASO DE ID=1
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setMessage("¿Quieres salir?");
				builder.setCancelable(false);
				builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
						// AQUI PRODIA LLAMARSE UN METODO DE LA ACTIVIDAD PARA PASAR DATOS
						dialog.dismiss();
					}
				});
				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
				AlertDialog alert = builder.create();
				return alert;
			default:
					return null;
		}
	}
	
	// SEGUNDO DIALOGO SIMPLE CON FRAGMENTOS
	public void cmdDlg2_Click(View v) {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		/*
		Fragment prev = getFragmentManager().findFragmentByTag("dlg2");
		if (prev != null) {
			ft.remove(prev);
		}
		ft.addToBackStack(null);
		*/
		DialogFragment dlg2 = Dlg2.newInstance("Este es el Dlg 2");
		dlg2.show(ft, "dlg2");
		// ft.add(dlg2, "dlg2"); // SI QUEREMOS UNA PILA DE FRAGMENTOS COMO UNO MAS
	}
	
	// TERCER DIALOGO
	public void cmdDlg3_Click(View v) {
		DialogFragment dlg3 = Dlg3.newInstance("Este es el Dlg 3");
		dlg3.show(getFragmentManager(), "dlg3");
	}
	
	// CUARTO DIALOGO
	public void cmdDlg4_Click(View v) {
		DialogFragment dlg4 = Dlg4.newInstance("Este es el Dlg 4");
		dlg4.show(getFragmentManager(), "dlg4");
	}
	
	// QUINTO DIALOGO
	public void cmdDlg5_Click(View v) {
		DialogFragment dlg5 = Dlg5.newInstance("Este es el Dlg 5");
		dlg5.show(getFragmentManager(), "dlg5");
	}
	
	// SEXTO DIALOGO
	public void cmdDlg6_Click(View v) {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		Fragment prev = getFragmentManager().findFragmentByTag("dlg6");
		if (prev != null) {
			ft.remove(prev);
		}
		ft.addToBackStack(null);
		
		DialogFragment dlg6 = Dlg6.newInstance("Este es el Dlg 6");
		dlg6.show(ft, "dlg6");
	}
	
	// CLIC EN LOS VALORES POSITIVOS
	public void doPositiveClick() {
		Toast.makeText(getApplicationContext(), "Si clic", Toast.LENGTH_SHORT).show();
	}
	
	public void doPositiveClick3(String val) {
		Toast.makeText(getApplicationContext(), "Si clic"+val, Toast.LENGTH_SHORT).show();
	}
	
	public void doPositiveClick4(String val) {
		Toast.makeText(getApplicationContext(), "Si clic"+val, Toast.LENGTH_SHORT).show();
	}
	
	public void doPositiveClick5(String val) {
		Toast.makeText(getApplicationContext(), "Si clic"+val, Toast.LENGTH_SHORT).show();
	}
	
	public void doPositiveClick6(String val) {
		Toast.makeText(getApplicationContext(), "Si clic"+val, Toast.LENGTH_SHORT).show();
		// HAY QUE BORRARLO PORQUE NO LO HACE DE FORMA AUTOMATICA
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		Fragment prev = getFragmentManager().findFragmentByTag("dlg6");
		if (prev != null) {
			ft.remove(prev);
		}
		ft.commit();
	}
	
	// CLIC EN LOS VALORES NEGATIVOS
	public void doNegativeClick() {
		Toast.makeText(getApplicationContext(), "No clic", Toast.LENGTH_SHORT).show();
	}
}
