package pmdm.ejemplo_dialogos;

import android.os.Bundle;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;

public class Dlg2 extends DialogFragment {
	public static DialogFragment newInstance(String title) {
		DialogFragment frag = new Dlg2();
		Bundle args = new Bundle();
		args.putString("titulo", title);
		frag.setArguments(args);
		return frag;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String title = getArguments().getString("titulo", "-DLG 2-");
		
		AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
		ab.setIcon(R.drawable.ic_launcher);
		ab.setTitle(title);
		ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				((MainActivity)getActivity()).doPositiveClick();
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
