package pmdm.ejercicio22;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Imagen extends Activity{
	Context ctx = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagen);
		
		ctx = this;
		
		View vw = this.findViewById(R.id.imageView1);
		registerForContextMenu(vw);
		
		Button btn = (Button) this.findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}
}
