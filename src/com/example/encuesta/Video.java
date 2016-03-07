package com.example.encuesta;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Video extends Activity {
	Button button_continuar;
	private InfoUser user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		user = new InfoUser();
		if(user.index >= 6){
			Intent intent = new Intent(this, Exp7.class);
			startActivity(intent);
			return;
		}
		user.sig = user.paso;
		Log.v("video paso: ", String.valueOf(user.paso)); 
		// Esto es por si el experimento es el 5, no debe presentar video, 
		// sino pasar directo al user.siguiente, luego debe pasar por aca en la mitad del exp.
		user.sig = user.sigPantalla();
		/*if(user.exp5parte != 3) {
			user.sig = user.sigPantalla();
			Log.v("entre a user.sig, nuevo paso es: ", String.valueOf(user.sig));
			if(user.sig == 5) {
				 Intent intent = new Intent(this, Exp5.class);
				 startActivity(intent);
				 return;
			}
		}*/
		setContentView(R.layout.activity_video);

		PlayVideo(); 

	}

	public void PlayVideo() {
		Uri uri = null;
		VideoView myVideoView = (VideoView) findViewById(R.id.videoView1);
		Log.v("video a mostrar", selectVideo());
		uri = Uri.parse(Environment.getExternalStorageDirectory()+"/" + selectVideo()/*"ejercicio_1.mp4"*/);
		Log.v("Uri video",uri.toString());
		myVideoView.setVideoURI(uri);
		//Comentariar la user.siguiente linea para quitar los contreoles.
		myVideoView.setMediaController(new MediaController(this));
		myVideoView.requestFocus();
		myVideoView.start();
		
		myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
			@Override
			public void onCompletion(MediaPlayer mp) {
				funcion_continuar();				
			}
		});
	}
	
	public String selectVideo() {
		if(user.index  > 6){
			Intent intent = new Intent(this, Exp7.class);
			startActivity(intent);
		}
		Log.v("el tipo video es:", String.valueOf(user.tipoVideo) );
		Log.v("el paso es:", String.valueOf(user.paso) );
		return String.valueOf(user.tipoVideo) + String.valueOf(user.index) + ".mp4";
	}
	
	public void  funcion_continuar() {
		// Borrar estas dos lineas, son solo de debug.
		Intent intent = new Intent(this, PreguntasAntes.class); 
		startActivity(intent);
		return;
		
		/*
		if(user.sig == 1 || user.sig == 2)
			 intent = new Intent(this, Exp1.class);
		if(user.sig == 3 || user.sig == 4)
			 intent = new Intent(this, Exp3.class);
		if(user.sig == 5)
			 intent = new Intent(this, MensajeExp5.class);
		if(user.sig == 6)
			 intent = new Intent(this, Exp6.class);
		// If otro vaya a gracias.
		startActivity(intent);*/

	}


}
