package pmdm.ejemplo_dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dlg4 extends DialogFragment {
	public static DialogFragment newInstance(String title) {
		DialogFragment frag = new Dlg4();
		Bundle args = new Bundle();
		args.putString("titulo", title);
		frag.setArguments(args);
		return frag;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String title = getArguments().getString("titulo", "-DLG 4-");
		final String[] items = {"Uno", "Dos", "Tres"};
		
		AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
		ab.setIcon(R.drawable.ic_launcher);
		ab.setTitle(title);
		ab.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				((MainActivity)getActivity()).doPositiveClick4(items[item]); // LLAMAR A LA ACTIVIDAD ANTES DE CERRAR
			}
		});
		return ab.create();
	}
}
