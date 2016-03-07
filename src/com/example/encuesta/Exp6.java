package com.example.encuesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Exp6 extends Activity {
	private InfoUser user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		user = new InfoUser();
		if(user.exp6parte == 1)
			setContentView(R.layout.activity_exp6_1);
		if(user.exp6parte == 2)
			setContentView(R.layout.activity_exp6_2);
		if(user.exp6parte == 3)
			setContentView(R.layout.activity_exp6_3);
		
	}
	
	public void continuar(View view) {
		String respuesta = (String) view.getTag();
		Intent intent = null;
		Log.v("Respuesta exp 1", respuesta + " parte " + user.exp6parte);
		if(user.exp6parte == 1) {
			intent = new Intent(this, Exp6.class);
			user.resExp61 = respuesta;
		}
		if(user.exp6parte == 2) {
			intent = new Intent(this, Exp6.class);
			user.resExp62 = respuesta;
		}
		if(user.exp6parte == 3) {
			intent = new Intent(this, PreguntasDespues.class);
			user.resExp63 = respuesta;
		}
		user.exp6parte ++;
		startActivity(intent);	
	}
}
