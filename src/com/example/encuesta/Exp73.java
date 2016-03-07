package com.example.encuesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class Exp73 extends Activity {
	private InfoUser user;
	private TextView textView, textView2;
	private  EditText seekBar, seekBar2;
	private EditText textoNumeros1, textoNumeros2;
	int seek1, seek2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		setContentView(R.layout.activity_exp73);
		user = new InfoUser();
		seekBar = (EditText) findViewById(R.id.textoNumeros1);
		textView = (TextView) findViewById(R.id.seekText);
		seekBar2 = (EditText) findViewById(R.id.textoNumeros2);
		textView2 = (TextView) findViewById(R.id.seekText2);
		/*seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			          int progress = 0;
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				               progress = progresValue;
				               seek1 = progresValue;
				               textView.setText(progress + "/" + seekBar.getMax());
			}
			  @Override
		      public void onStartTrackingTouch(SeekBar seekBar) {	
		      }
		      @Override
		      public void onStopTrackingTouch(SeekBar seekBar) {*/
		              /*textView.setText("Covered: " + progress + "/" + seekBar.getMax());
		              Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();*/
		        /* }

		});
		
		
		seekBar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
	          int progress = 0;
				@Override
				public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
					               progress = progresValue;
					               seek2 = progresValue;
					               textView2.setText(progress + "/" + seekBar.getMax());
				}
				  @Override
			    public void onStartTrackingTouch(SeekBar seekBar) {	
			    }
			    @Override
			    public void onStopTrackingTouch(SeekBar seekBar) {*/
			            /*textView.setText("Covered: " + progress + "/" + seekBar.getMax());
			            Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();*/
			    //   }
			
		//}); 

	}

	public void continuar(View view) {
		user.ownEndowment = String.valueOf(seekBar);
		
		user.jointEndowment = String.valueOf(seekBar2);
		
		RadioGroup radio = (RadioGroup) findViewById(R.id.radioC);
		RadioButton selected = (RadioButton) findViewById(radio.getCheckedRadioButtonId());
		user.againstComputer = selected.getText().toString();
		
	    radio = (RadioGroup) findViewById(R.id.radioD);
		selected = (RadioButton) findViewById(radio.getCheckedRadioButtonId());
		user.againstYour = selected.getText().toString();
		
	    radio = (RadioGroup) findViewById(R.id.radioE);
		selected = (RadioButton) findViewById(radio.getCheckedRadioButtonId());
		user.trustParty = selected.getText().toString();
		
		Intent intent = new Intent(this, Gracias.class);
		startActivity(intent);
	}
}
