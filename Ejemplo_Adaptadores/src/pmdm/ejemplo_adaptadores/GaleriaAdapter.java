package pmdm.ejemplo_adaptadores;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GaleriaAdapter extends BaseAdapter
{
	int mGalleryItemBackground;
	private Context mContext;
	
	// imagenes a gestionar
	private Integer[] mImageIds = 
	{
		R.drawable.sample01,
		R.drawable.sample02,
		R.drawable.sample03,
		R.drawable.sample04,
		R.drawable.sample05,
		R.drawable.sample06,
		R.drawable.sample07
	};
	
	public GaleriaAdapter(Context c)
	{
		mContext = c;
		TypedArray attr = mContext.obtainStyledAttributes(R.styleable.Galería);
		mGalleryItemBackground = attr.getResourceId(
				R.styleable.Galería_android_galleryItemBackground, 0);
		attr.recycle();
	}
	
	public int getCount()
	{
		return mImageIds.length;
	}
	
	public Object getItem(int position)
	{
		return mImageIds[position];
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
		
		ll.setOrientation(LinearLayout.VERTICAL);
		
		img.setImageResource(mImageIds[position]);
		img.setLayoutParams(new Gallery.LayoutParams(100, 150));
		img.setScaleType(ImageView.ScaleType.FIT_XY);
		img.setBackgroundResource(mGalleryItemBackground);
		
		tvTit.setText("Nombre "+ Integer.toString(position));
		tvTit.setGravity(Gravity.CENTER_HORIZONTAL);
		
		ll.addView(img);
		ll.addView(tvTit);
		
		return ll;
	}
}
