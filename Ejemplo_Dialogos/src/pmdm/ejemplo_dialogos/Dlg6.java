package pmdm.ejemplo_dialogos;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Dlg6 extends DialogFragment {
	public static DialogFragment newInstance(String title) {
		DialogFragment frag = new Dlg5();
		Bundle args = new Bundle();
		args.putString("titulo", title);
		frag.setArguments(args);
		return frag;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// EL DIALOGO SIN EL ESPACIO DEL TITULO
		setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Dialog);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.dlg6, container, false); // CARGAR EL UI
		View tv = v.findViewById(R.id.text); // ESTABLECER EL TITULO
		((TextView)tv).setText("Texto del dialogo");
		
		Button button = (Button)v.findViewById(R.id.cmd); // MANEJAR EL EVENTO DEL BOTON
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// COMUNICARSE CON LA ACTIVIDAD PRINCIPAL
				((MainActivity)getActivity()).doPositiveClick6("Texto devuelto");
			}
		});
		
		return v;
	}

}
