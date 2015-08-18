package pmdm.ejemplo_dialogos;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Activity;
import android.content.DialogInterface;

public class Dlg3 extends DialogFragment {
	private TextView url; // REFERENCIA PARA RECOGER Y PODER MANDAR LOS DATOS
	
	public static DialogFragment newInstance(String title) {
		DialogFragment frag = new Dlg3();
		Bundle args = new Bundle();
		args.putString("titulo", title);
		frag.setArguments(args);
		return frag;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String title = getArguments().getString("titulo", "-DLG 3-");
		// CARGAR EL LAYOUT
		final View form = getActivity().getLayoutInflater().inflate(R.layout.dlg3, null);
		url = (TextView) form.findViewById(R.id.url);
		
		AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
		ab.setIcon(R.drawable.ic_launcher);
		ab.setTitle(title);
		ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				((MainActivity)getActivity()).doPositiveClick3(url.getText().toString());
			}
		});
		ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				((MainActivity)getActivity()).doNegativeClick();
			}
		});
		return ab.create();
	}
}
