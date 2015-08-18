package pmdm.ejemplo_adaptadores;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListaModAdapter extends BaseAdapter
{
	int nGalleryItemBackground;
	private Context mContext;
	private String []datos;
	
	public ListaModAdapter(Context c)
	{
		mContext = c;
		datos = c.getResources().getStringArray(R.array.lista);
	}
	
	public int getCount()
	{
		return datos.length;
	}
	
	public Object getItem(int position)
	{
		return datos[position];
	}
	
	public long getItemId(int position)
	{
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LinearLayout ll = new LinearLayout(mContext);
		TextView tvTit = new TextView(mContext);
		ImageView img = new ImageView(mContext);
		
		ll.setOrientation(LinearLayout.HORIZONTAL);
		
		img.setImageResource(R.drawable.ic_launcher); // el icono es fijo
		img.setLayoutParams(new LinearLayout.LayoutParams(24, 24)); // tamaño del icono
		img.setScaleType(ImageView.ScaleType.FIT_XY); // escalar la imagen
		
		tvTit.setText(datos[position]);
		tvTit.setGravity(Gravity.LEFT);
		
		ll.addView(img);
		ll.addView(tvTit);
		
		return ll;
	}
}
