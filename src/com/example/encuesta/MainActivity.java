package com.example.encuesta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("DefaultLocale")
public class MainActivity extends Activity {
	private InfoUser user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		user = new InfoUser();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public void  mainActivityAdvance(View view) {
         // Se obtiene la cedula del campo de texto.
		 EditText editText = (EditText) findViewById(R.id.idMainActivity);
		 String genero = (String) view.getTag();

		 String id = editText.getText().toString();
		
		 Log.v("texto id persona", editText.getText().toString()+"l");
		 
		 // Encontramos el valor de la cedula.
		 // TODO(camilo): Hacer la funcion.
		 // InfoPersona a = ReadCsv(num_cedula);
		String video = Utils.tipoVideo(id);
		//CAMBIAR
		if(video == null)
		{
			// Solo para debug **********borrrar************.
			//Utils.guardarInfo("a,b,c,d,e");
			
			// Solo para debug **********borrrar************.
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Alert");
			alertDialog.setMessage("ID not found");
			
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// here you can add functions
			}
			});
			alertDialog.show();
			return;
		}
		user.start(id);
		user.genero = genero;
		user.tipoVideo = Utils.tipoVideo(id);
		RadioGroup radio = (RadioGroup) findViewById(R.id.radioC);
		RadioButton selected = (RadioButton) findViewById(radio.getCheckedRadioButtonId());
		user.marrital = selected.getText().toString();
		Log.v("Tipo video es: ", String.valueOf(user.tipoVideo));
		//Intent intent = new Intent(this, Video.class);
		Intent intent = new Intent(this, Preguntas_control.class);
		//Intent intent = new Intent(this, Gracias.class);

		// Asi pasamos informacion.
		// intent.putExtra("persona", a); 
		startActivity(intent);	
	}
	
}
