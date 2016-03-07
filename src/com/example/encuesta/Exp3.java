package com.example.encuesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Exp3 extends Activity {
	private InfoUser user;
	String res;
	int cont;
	String part1a, part2a, part1b, part2b, valor_quieto;
	String[] vals;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exp3);
		user = new InfoUser();
		res = "";
		cont = 0;
		part1a = "الاختيار أ: الحصول  على"; // Part a recieve
		part2a = " جنيه بعد شهرواحد"; //Pounds after one month.
		part1b = "الاختيار ب: الحصول على";
		if(user.paso == 3) {
			vals  = new String[]{"٣٠","٣٣","٤٠","٤٥","٥٠"};
			valor_quieto = "٢٥";
			//CAMBIADO
			part2b = " بعد شهرين"; //despues de 2 meses
		} else if(user.paso == 4) {
			vals  = new String[]{"٥٥","٦٥","٨٠","٩٠","١٠٠"};
			valor_quieto = "٢٠";
			//CAMBIADO
			part2b = " بعد سبعة أشهر"; //despues de 7 meses
		} 
		calcular(null);
	}
	
	public void terminar(){
		if(user.paso == 3)
			user.resExp3 = res;
		if(user.paso == 4)
			user.resExp4 = res;
		Log.v("Respuesta exp 1", res); 
		Intent intent = new Intent(this, PreguntasDespues.class);
		startActivity(intent);
	}
	
	public void calcular(View view) {
		if(cont >= 5){
			String respuesta = (String) view.getTag();
			res = res + respuesta;
			terminar();
			return;
		}
		
		Log.v("func calcular cont ess=", String.valueOf(cont));
		Button text_a = (Button) findViewById(R.id.op_a);
		Button text_b = (Button) findViewById(R.id.op_b);
		text_a.setText(part1a + "١٠٠" + part2a);
		text_b.setText(part1b + vals[cont] + part2b);
		
		// Si es la primera vez solo se hace set de los text.
		if(cont == 0){cont++;return;} 
		String respuesta = (String) view.getTag();
		Log.v("func calcular op usuario es=", respuesta);
		
		if(respuesta.equals("A") || respuesta.equals("C") ) {
			res = res + respuesta;
		} else {
			Log.v("No es B", "No es B");
			for(; cont <= vals.length; cont++){
				res = res + "B";
				Log.v("No es B for", String.valueOf(cont));
			}
			terminar();
			return;
		}
		
		Log.v("Cont y vals es=", String.valueOf(cont) + " "  +String.valueOf(vals.length) );
		// We get the number of tries from the array of values to make it variable.
		
		cont++;
	}
}
