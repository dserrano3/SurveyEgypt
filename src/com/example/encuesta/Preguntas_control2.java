package com.example.encuesta;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class Preguntas_control2 extends Activity {
	int conta;
	private InfoUser user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Explanation");
		alertDialog.setMessage("As in the previous two tasks you will be given " +
				"10 trials to toss a ball into a bucket that is 3 meters far." +
				" However, you will now get to choose which of the two previous " +
				"payment schemes you prefer to apply to your performance on this activity.");
		
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			// here you can add functions
		}
		});
		alertDialog.show();*/
		setContentView(R.layout.activity_exp5);
		conta = 0;
		user = new InfoUser();
	}
	
	public void continuar(View view) {
		CheckBox chkIos = (CheckBox) findViewById(R.id.checkBox1);
		if (chkIos.isChecked())
			conta ++;
		/*chkIos = (CheckBox) findViewById(R.id.checkBox1);
		if (chkIos.isChecked())
			conta ++;*/
		chkIos = (CheckBox) findViewById(R.id.checkBox2);
		if (chkIos.isChecked())
			conta ++;
		chkIos = (CheckBox) findViewById(R.id.checkBox3);
		if (chkIos.isChecked())
			conta ++;
		chkIos = (CheckBox) findViewById(R.id.checkBox4);
		if (chkIos.isChecked())
			conta ++;
		chkIos = (CheckBox) findViewById(R.id.checkBox5);
		if (chkIos.isChecked())
			conta ++;
		chkIos = (CheckBox) findViewById(R.id.checkBox6);
		if (chkIos.isChecked())
			conta ++;
		chkIos = (CheckBox) findViewById(R.id.checkBox7);
		if (chkIos.isChecked())
			conta ++;
		chkIos = (CheckBox) findViewById(R.id.checkBox8);
		if (chkIos.isChecked())
			conta ++;
		chkIos = (CheckBox) findViewById(R.id.checkBox9);
		if (chkIos.isChecked())
			conta ++;
		chkIos = (CheckBox) findViewById(R.id.checkBox10);
		if (chkIos.isChecked())
			conta ++;
		
		Log.v("Exp 5 user", String.valueOf(user.control2_parte));
	
	
		AlertDialog.Builder builder = new Builder(this);
	    builder.setMessage("You scored a total of: " + conta + " balls");
	    builder.setTitle("Messagee");
	    builder.setCancelable(false);
	    
		
		if(user.control2_parte == 1){
			user.control_2A = String.valueOf(conta);
			user.control2_parte ++;
			Log.v("Respuesta exp 5 part 1: ", String.valueOf(conta)); 
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) {	
		        	Intent intent = new Intent(Preguntas_control2.this, Preguntas_control.class);
					startActivity(intent);
					
				
		        }
		    });

		    builder.create().show();

		}else if(user.control2_parte == 2){
			user.control_2B = String.valueOf(conta);
			Log.v("Respuesta exp 5 part 2: ", String.valueOf(conta)); 
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) {	
					Intent intent = new Intent(Preguntas_control2.this, Preguntas_control.class);
					startActivity(intent);
		        }
		    });
			builder.create().show();

		}
	}
}
