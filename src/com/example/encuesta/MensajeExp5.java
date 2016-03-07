package com.example.encuesta;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MensajeExp5 extends Activity {
	private InfoUser user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mensaje_exp5);
		user = new InfoUser();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Explanation");
		alertDialog.setMessage("في هذه اللعبة زى ما قولنا قبل كدة حنرمى ١٠ كرات داخل السلة. ولكن دلوقتى ليك أنك تختار الطريقة ال" +
				"تفضلها عشان تكسب  فلوس" +
				"يعنى انك حتختار اما تلعب لوحدك و تكسب 5 جنيه لكل محاولة ناجحة وإما أن تتنافس وتكسب ١٥  جنيه " +
				"لكل محاولة ناجحة لو كسبت المباراة. في المرحلة دى  عشان تكسب المنافسة لازم تسجل كرات أكتر من " +
				"ال حيسجلها الشخص التانى في المرحلة التانية فى حالة التعادل حنختار الرابح عشوائياً");
		
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			// here you can add functions
		}
		});
		alertDialog.show();

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mensaje_exp5, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) { 
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void continuar(View view) {
		String forma = (String) view.getTag();
		user.formaExp5 = forma;
		Log.v("Mensajeexp5 res=", forma);
		user.exp5parte ++;
		Intent intent = new Intent(this, Exp5.class);
		startActivity(intent);
	
	}
}
