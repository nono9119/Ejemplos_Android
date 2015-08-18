package pmdm.ejemplo_notificaciones;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void cmdFin_Click(View v) {
		// RECOGER LA REFERENCIA AL NOTIFICATION MANAGER
		NotificationManager mNotificationManager = 
				(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// CREAR LA NOTIFICACION
		int icon = R.drawable.ic_launcher;
		CharSequence tickerText = "Hola";
		long when = System.currentTimeMillis(); // CUANDO SE LANZARA LA APLICACION	
		Notification notification = new Notification(icon, tickerText, when);
		
		// CONFIGURAR LA NOTIFICACION
		Context context = getApplicationContext();
		CharSequence contentTitle = "Mi notificacion"; // TITULO
		CharSequence contentText = "Hola!";
		Intent notificationIntent = new Intent(this, NotificacionActividad.class);
		// NotificacionActividad DEBE EXISTIR COMO ACTIVIDAD Y EN EL MANIFEST
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
 
		// PASAR LA NOTIFICACION AL MANEJADOR, 
		// EL ID NOS SERA DEVUELTO EN EL INTENT Y DEBE SER UNICO SI HAY VARIAS
		final int HELLO_ID = 1;
		mNotificationManager.notify(HELLO_ID, notification);
		
		finish(); 
	}
	
	public void cmdFin2_Click(View v) {
		// RECOGER LA REFERENCIA AL NotificationManager
		NotificationManager mNotificationManager = 
				(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		// CREAR LA NOTIFICACION
		int icon = R.drawable.ic_launcher;
		CharSequence tickerText = "Hola";
		long when = System.currentTimeMillis(); 
		// INSTANCIAR EL UI Y PONER LOS DATOS
		RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notificacion);
		contentView.setImageViewResource(R.id.image, R.drawable.ic_launcher);
		contentView.setTextViewText(R.id.title, "Personalizada");
		contentView.setTextViewText(R.id.text, "Texto Personalizado");
		Notification notification = new Notification(icon, tickerText, when);
		notification.contentView = contentView;
		notification.flags |= Notification.FLAG_AUTO_CANCEL; // UNA VEZ PULSADA SE BORRA AUTOMATICAMENTE
		
		// CONFIGURAR LA NOTIFICACION
		Intent notificationIntent = new Intent(this, NotificacionActividad.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.contentIntent = contentIntent; // EN VEZ DEL setLastestEventInfo
		
		// PASAR LA NOTIFICACION AL MANEJADOR, 
		// EL ID NOS SERA DEVUELTO EN EL INTENT Y DEBE SER UNICO SI HAY VARIAS
		final int HELLO2_ID = 2;
		mNotificationManager.notify(HELLO2_ID, notification);
		
		finish();
	}

}
