package pmdm.ejemplo_dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


public class Dlg5 extends DialogFragment {
	final String[] items = {"Uno", "Dos", "Tres"};
	protected String val = items[0]; // VALOR POR DEFECTO
	
	public static DialogFragment newInstance(String title) {
		DialogFragment frag = new Dlg5();
		Bundle args = new Bundle();
		args.putString("titulo", title);
		frag.setArguments(args);
		return frag;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String title = getArguments().getString("titulo", "-DLG 5-");
		
		AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
		ab.setIcon(R.drawable.ic_launcher);
		ab.setTitle(title);
		ab.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int item) {
				val = items[item];
			}
		});
		ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int whichButton) {
				// LLAMAR PASANDO EL PARAMETRO
				((MainActivity)getActivity()).doPositiveClick5(val);
			}
		});
		ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int whichButton) {
				((MainActivity)getActivity()).doNegativeClick();
			}
		});
		return ab.create();
	}
}
