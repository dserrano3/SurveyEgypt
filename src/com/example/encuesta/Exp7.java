package com.example.encuesta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Exp7 extends Activity {
	
	private InfoUser user;
	
	private String[] third_parties = new String[]{"مشروع الهلال الأحمر لحماية الفتيات العاملات في حلوان -", "مشروع الهلال الأحمر ل تحسين فعالية الإغاثة في حالات الكوارث-", "مشروع الهلال الأحمر لمنع عمالة الأطفال-"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exp7);
		user = new InfoUser();
		Random rnd = ThreadLocalRandom.current();
		
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Explanation");
		alertDialog.setMessage("هنا مش حنقدملك فيديو، اللعبة دى مقسومة لأربع أجزاء، واحد من الأربعة حنختاره عشان ندفعلك الكمية المناسبة بحسب الاختيارات ال أخترتها سيتم الأختيار عشوائياً");
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			// here you can add functions
		}
		});
		alertDialog.show();
		
		
		
		if(user.exp7_1_parte == 0)
			user.exp7_1_parte = rnd.nextInt(2) + 1;

		if(user.exp7_1_parte == 1) {
			// Seteo lo anterior en cero.
			ImageView myImage= (ImageView) findViewById(R.id.imageView1);
			TextView t1=(TextView)findViewById(R.id.imagen_partner); 
			TextView t2=(TextView)findViewById(R.id.imagen_third); 
			//TextView t3=(TextView)findViewById(R.id.imagen_third2); 
			myImage.setVisibility(View.VISIBLE);
			t1.setText(".");
			t2.setText(".");
			//t3.setText(".");

			if(user.third_party == null)
				user.third_party = third_parties[rnd.nextInt(third_parties.length)];
			TextView t=(TextView)findViewById(R.id.main_text); 
		    
			myImage= (ImageView) findViewById(R.id.imageView2);
			t1=(TextView)findViewById(R.id.imagen_third_3); 
			myImage.setImageResource(R.drawable.texto_arabe_2);
			myImage.setVisibility(View.VISIBLE);
			t1.setText(user.third_party);

			
			/*t.setText("حنديلك ٣٠ جنيه وممكن تقسم المبلغ دة بينك وبين ("+ user.third_party+ "). لما تنتهى اللعبة ولو تم أختيار القرار ال" +
		    		" أخترتة حنديلك ال " +
		    		"حيتبقى من الفلوس بعد ما ندى ال"+ user.third_party+" القيمة ال أنتى اخترتها"
		    		);*/
		}
		else if(user.exp7_1_parte == 2){
			if(user.third_party == null)
				user.third_party = third_parties[rnd.nextInt(third_parties.length)];
			user.partner = getPartner();
			//Seteo lo anterior en cero.
			ImageView myImagea= (ImageView) findViewById(R.id.imageView2);
			TextView t1a=(TextView)findViewById(R.id.imagen_third_3); 
			myImagea.setVisibility(View.INVISIBLE);
			t1a.setText(".");
			
			// Ahora si lo de este.
			TextView t=(TextView)findViewById(R.id.main_text); 
			// Update to image.
			ImageView myImage= (ImageView) findViewById(R.id.imageView1);
			TextView t1=(TextView)findViewById(R.id.imagen_partner); 
			TextView t2=(TextView)findViewById(R.id.imagen_third); 
			//TextView t3=(TextView)findViewById(R.id.imagen_third2); 
			myImage.setImageResource(R.drawable.texto_arabe_1);
			myImage.setVisibility(View.VISIBLE);
			t1.setText(user.partner);
			t2.setText(user.third_party);
			//t3.setText(user.third_party);

		    /*t.setText("حنختار(" + user.partner + ")، علشان يشاركك فى٦٠ جنيه ،. كل واحد منكم لازم يقرر ازاى حيقسم" +
		    		" المبلغ دة يعنى تحدد " +user.third_party +"ال أنت عايز تاخدها والقيمة ال انت عايز" +
		    		" تديها للشريك والقيمة ال أنت عايز تديها للمؤسسة لو أخترت هذه اللعبة" +
		    		" ، حنقدم  " +user.third_party +" القيمة المناسبة حسب قرار الفائزووحتاخد أنت والشخص" +
		    		" التانى ال حيتبقى وحتتقسم القيمة بالتساوى فيما بينكم في نهاية" +
		    		" اللعبة حنختار عشوائياً القرار ال حيتنفذ، إما قرارك أو قرارالشريك");*/
		}
		
	}
	 
	public void esconder(View view){
		TextView t = (TextView)findViewById(R.id.main_text); 
		t.setText(" ");
		 if(user.exp7_1_parte == 1){
		TextView a = (TextView)findViewById(R.id.textView); 
		a.setText(user.third_party + "حنديلك ٣٠ جنيه قد اية من المبلغ عايز تقدم (للمؤ)");
		 }
		 else  if(user.exp7_1_parte == 2){
			 TextView a = (TextView)findViewById(R.id.textView); 
				a.setText("حنديلك أنت وشريكك 60 جنيه تتشاركو فيها . قد اية من المبلغ عايز تدى ( " +user.third_party +" ) ؟");
		 }
		Button playButton = (Button) findViewById(R.id.button1);
	    playButton.setVisibility(View.VISIBLE); //View.VISIBLE
	    playButton = (Button) findViewById(R.id.button2);
	    playButton.setVisibility(View.GONE); 
	    EditText et=(EditText)findViewById(R.id.respuesta_7);
	    et.setVisibility(View.VISIBLE);
	    
	}
	
	
	public String getPartner() {
		Random rnd = ThreadLocalRandom.current();
		int aleatorio = 0;
		if(user.marrital.equals("متزوج- متزوجة"))
			aleatorio = rnd.nextInt(3);
		else
			aleatorio = rnd.nextInt(2);
		if(aleatorio == 0) {
			// Random man.
			return "رجل نختاره عشوائياً ";
		} else if(aleatorio == 1){
			return "ست نخترها عشوائيا";
		} else {
			if(user.genero.equals("male")){
				return "الزوجة ";
			} else {
				return "شريكك هو: الزوج";
			}
		}
	}
	
	  // add items into spinner dynamically
	

	public void continuar(View view) {
		
		/*Spinner spinner = (Spinner) findViewById(R.id.options_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.options_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);*/
		
		//Log.v("Continuar, parte: ", String.valueOf(user.exp7_1_parte));

		EditText res = (EditText)findViewById(R.id.respuesta_7);
		if(user.exp7_1_parte == 1) {
			user.resExp711 = res.getText().toString();
			if(user.resExp711.equals(""))
				user.resExp711 = "0";
			if(Integer.valueOf(user.resExp711)>30 || Integer.valueOf(user.resExp711)<0){
				AlertDialog alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Alert");
				alertDialog.setMessage("number out of range");
				
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// here you can add functions
				}
				});
				alertDialog.show();
				return;
			}
			Log.v("Entre a parte 1: ", String.valueOf(user.resExp711));
			user.exp7_1_parte ++;
		} else if(user.exp7_1_parte == 2) {
			user.resExp712 = res.getText().toString();
			if(user.resExp712.equals(""))
				user.resExp712 = "0";
			if(Integer.valueOf(user.resExp712)>60 || Integer.valueOf(user.resExp712)<0){
				AlertDialog alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Alert");
				alertDialog.setMessage("number out of range");
				
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// here you can add functions
				}
				});
				alertDialog.show();
				return;
			}
			Log.v("Entre a parte 2: ", String.valueOf(user.resExp712));
			user.exp7_1_parte --;
		}
		if(!user.entre_71){
			user.entre_71 = true;
			Intent intent = new Intent(this, Exp7.class);
			startActivity(intent);
			return;
		}
		
		Intent intent = new Intent(this, Exp72.class);
		startActivity(intent);
	}
}
