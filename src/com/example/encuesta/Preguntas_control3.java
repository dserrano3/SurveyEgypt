package com.example.encuesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Preguntas_control3 extends Activity {
	private InfoUser user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		user = new InfoUser();
		if(user.control3_parte == 1)
			setContentView(R.layout.activity_preguntas_control31);
		if(user.control3_parte == 2)
			setContentView(R.layout.activity_preguntas_control32);
		if(user.control3_parte == 3)
			setContentView(R.layout.activity_preguntas_control33);
		
	}
	
	public void continuar(View view) {
		String respuesta = (String) view.getTag();
		Intent intent = null;
		Log.v("Respuesta exp 1", respuesta + " parte " + user.control3_parte);
		if(user.control3_parte == 1) {
			intent = new Intent(this, Preguntas_control3.class);
			user.control_3A = respuesta;
		}
		if(user.control3_parte == 2) {
			intent = new Intent(this, Preguntas_control3.class);
			user.control_3B = respuesta;
		}
		if(user.control3_parte == 3) {
			intent = new Intent(this, Video.class);
			user.control_3C = respuesta;
		}
		user.control3_parte ++;
		startActivity(intent);	
	}
}
