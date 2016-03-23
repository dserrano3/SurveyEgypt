package com.example.encuesta;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class Gracias extends Activity {
	private InfoUser user;
	String[] vals3  = new String[]{"30","33","40","45","50"};
	String[] vals4  = new String[]{"55","65","80","90","100"};
	int exp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gracias);
		user = new InfoUser();
		Button playButton = (Button) findViewById(R.id.red);
	    playButton.setVisibility(View.GONE); //View.VISIBLE
	    playButton = (Button) findViewById(R.id.green);
	    playButton.setVisibility(View.GONE); //View.VISIBLE
	    playButton = (Button) findViewById(R.id.button2);
	    playButton.setVisibility(View.GONE); //View.VISIBLE
	    View a = findViewById(R.id.texto7);
	    a.setVisibility(View.GONE); //View.VISIBLE
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gracias, menu);
		
		return true;
	}
	public void random(View view) {
		
		View a = findViewById(R.id.texto7);
	    a.setVisibility(View.VISIBLE); //View.VISIBLE
		 
		exp = seleccionarExperimento();
		//exp = 1;

		 user.selected = exp;
		 
		 if(exp>9 || exp<1 || exp == 7){
			 AlertDialog alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Alert");
				alertDialog.setMessage("Experiment not found");
				
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// here you can add functions
				}
				});
				alertDialog.show();
				return;
		 }
		 /*TextView t = (TextView)findViewById(R.id.exp_selected); 
			t.setText("Experiment selected is: " + exp);*/
		 if(exp == 1 || exp == 2) {
				Button playButton = (Button) findViewById(R.id.red);
			    playButton.setVisibility(View.VISIBLE); //View.VISIBLE
			    playButton = (Button) findViewById(R.id.green);
			    playButton.setVisibility(View.VISIBLE); //View.VISIBLE
			    
			    
			    TextView t = (TextView)findViewById(R.id.selected); 
				t.setText("رجاءً قم بإختيار لون الكرة ");
				
				playButton = (Button) findViewById(R.id.button1);
			    playButton.setVisibility(View.GONE); //View.VISIBLE
				//terminar();
			    
			    	
			    
		 }
		 if(exp == 3) {
			 Random rnd = ThreadLocalRandom.current();
			 int max = vals3.length-1;
			 for(int i = 0; i < vals3.length; i++){
				 Log.v("dentro del for de exp3", vals3[i]);
				 if(user.resExp3.charAt(i) == 'B') {
					 max = i;
					 break;
				 }
			 }
			 int pos = rnd.nextInt(max + 1);
			 String msg = "Desition was between 25 in one month or " + vals3[pos] + " in two months.\n" +
			               "You chose option " + user.resExp3.charAt(pos) + " earning " + (user.resExp3.charAt(pos) == 'A'?"100":vals3[pos]);
			 TextView t = (TextView)findViewById(R.id.aux); 
			 t.setText(msg);
			 user.pago = String.valueOf(user.resExp3.charAt(pos));
			 user.color = String.valueOf(pos + 1);
			 terminar();
		 }
		 if(exp == 4) {
			 Random rnd = ThreadLocalRandom.current();
			 int max = vals4.length-1;
			 for(int i = 0; i < vals4.length; i++){
				 if(user.resExp4.charAt(i) == 'B') {
					 max = i;
					 break;
				 }
			 }
			 int pos = rnd.nextInt(max+1);
			 String msg = "Desition was between 20 in one month or " + vals4[pos] + " in seven months.\n" +
			               "You chose option " + user.resExp4.charAt(pos)  + " earning " + (user.resExp4.charAt(pos) == 'A'?"100":vals4[pos]);;
			 TextView t = (TextView)findViewById(R.id.aux); 
			 t.setText(msg);
			 user.pago = String.valueOf(user.resExp4.charAt(pos));
			 user.color = String.valueOf(pos + 1);
			 terminar();
		 }
		 if(exp == 5) {
			 String msg = "";
			 Random rnd = ThreadLocalRandom.current();
			 int pantalla = rnd.nextInt(3) + 1;
			 //pantalla = 2;
			 if(user.formaExp5.equals("A")){
				 msg = "Part 3 was selected you have " + user.resExp53 + " balls.\n" +
			               "You earn " + Integer.valueOf(user.resExp53) * 5;
				 user.pago = String.valueOf(Integer.valueOf(user.resExp53) * 5);
			 }
			 if(user.formaExp5.equals("B")){
				 int valorOtro = valorOtro(3);
				 int pago = 0;
				 if(Integer.valueOf(user.resExp53) > valorOtro) {
					 //cambiado
					 pago = 15*Integer.valueOf(user.resExp53);
				 }
				  msg = "Part 3 was selected you have " + user.resExp53 + " balls, the other player has: "
						 + valorOtro + " balls" +"\n" +"You earn " + pago;
				 user.pago = String.valueOf(pago);
			 }
			 
			 TextView t = (TextView)findViewById(R.id.aux); 
			 t.setText(msg);
			 
			 terminar();
		 }
		 if(exp == 6) {
			 String msg = "";
			 int tot = 0;
				  msg += "Desition 1 , correct answer was 3, and you selected " + user.resExp61;
			 if(user.resExp61.equals("3"))
				 tot += 15;


			  msg += " \nDesition 2 , correct answer was 2, and you selected " + user.resExp62;
			 if(user.resExp62.equals("2"))
				 tot += 15;

			  msg += " \nDesition 3 , correct answer was 5, and you selected " + user.resExp63;
			 if(user.resExp63.equals("5"))
				 tot += 15;

			 user.pago = String.valueOf(tot);
			 msg += "\nYou receive " + user.pago;
			 TextView t = (TextView)findViewById(R.id.aux); 
			 t.setText(msg);
			 terminar();
		 }
		 if(exp == 8) {
			 // Control with images.
			 
			 int correct = 0;
			 if(user.control_3A.equals("1"))
				 correct ++;
			 if(user.control_3B.equals("1"))
				 correct ++;
			 if(user.control_3C.equals("5"))
				 correct ++;
			 
			 String msg = "Control experiment, 8 selected. You have: " +
			 String.valueOf(correct) + " correct, \n you earn: " + String.valueOf(15*correct);
			 
			 user.pago = String.valueOf(15*correct);
			 TextView t = (TextView)findViewById(R.id.aux); 
			 t.setText(msg);
			 terminar();
		 } if(exp == 9) {
			 // Control with images.
			 Random rnd = ThreadLocalRandom.current();
			 int pantalla = rnd.nextInt(2);
			 String msg  = "";
			 String pago;
			 if(pantalla == 0) {
				 pago = String.valueOf(Integer.valueOf(user.control_2A) * 5);
				 msg = "In the first part you scored: " + user.control_2A + " points" +
						 " earning " + pago;
			 }else {
				 pago = String.valueOf(Integer.valueOf(user.control_2A) * 15);
				 msg = "In the second part you scored: " + user.control_2B + " points" +
						 " earning " + pago;
			 }
			 user.pago = pago;
			 TextView t = (TextView)findViewById(R.id.aux); 
			 t.setText(msg);
			 terminar();
		 }
	}
	/*******cambiado*************/
	public void exp1_2(View view) {
		user.color = (String) view.getTag();
		TextView t = (TextView)findViewById(R.id.pay1_2);
		t = (TextView)findViewById(R.id.selected); 
		if(exp==1){
		    if(user.color.equals("green")){
		    	int pago = Math.max(Integer.valueOf(user.resExp1.split("\\|")[0]),Integer.valueOf(user.resExp1.split("\\|")[1]));
		    	Log.v("Respuesta pago 1", String.valueOf(pago));
		    	user.pago = String.valueOf(pago);
		    	t.setText("your payment is " +pago + " EGP");
				terminar();
		    }else
		    if(user.color.equals("red")){
		    	int pago = Math.min(Integer.valueOf(user.resExp1.split("\\|")[0]),Integer.valueOf(user.resExp1.split("\\|")[1])); 
		    	t.setText("your payment is " +pago + " EGP");
				terminar();
		    }
		}else if(exp==2){
		    if(user.color.equals("green")){
		    	int pago = Math.max(Integer.valueOf(user.resExp2.split("\\|")[0]),Integer.valueOf(user.resExp2.split("\\|")[1]));
		    	Log.v("Respuesta pago 1", String.valueOf(pago));
		        
		    	// Quoting Marcela: 
		    	// It should subtract negative numbers from 50 and add positive nunbers to 50. 
		    	pago = 50 + pago;
		    	Log.v("Respuesta pago 2", user.pago);
		    	user.pago = String.valueOf(pago);
		    	t.setText("your payment is " +pago + " EGP");
				terminar();
		    }else
		    if(user.color.equals("red")){
		    	int pago = Math.min(Integer.valueOf(user.resExp2.split("\\|")[0]),Integer.valueOf(user.resExp2.split("\\|")[1])); 
		    	Log.v("Respuesta pago 1", String.valueOf(pago));
		    	pago = 50 + pago;
		    	user.pago = String.valueOf(pago);
		    	t.setText("your payment is " +pago + " EGP");
				terminar();
		    }
		}
		
	}
	
	public void continuar(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		return;
	}
	
	
	public int seleccionarExperimento() {
		EditText mEdit = (EditText)findViewById(R.id.exp_pago);
		return Integer.valueOf(mEdit.getText().toString());
	}
	
	public void terminar(){
		Log.v("Respuesta final pago", user.pago);
		Utils.guardarInfo(user.writeRes());
	    Button playButton = (Button) findViewById(R.id.button2);
	    playButton.setVisibility(View.VISIBLE); //View.VISIBLE
	    playButton = (Button) findViewById(R.id.button1);
	    playButton.setVisibility(View.GONE); //View.VISIBLE
		//TODO: Implement.
	}
	public int valorOtro(int parte){
		return Integer.valueOf(Utils.ReadCsvValuesOther(parte));
	}
}
