


package com.example.encuesta;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Exp1 extends Activity {
	private InfoUser user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(user.paso == 1) {
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Explanation");
			alertDialog.setMessage("زى ماشرحنا قبل كدة حنطلب منك مقارنة بعض الإختيارات الاسثتثمارية وبعدها تختار القرارالاسثماري ال تظن إنه الأنسبلك اوال تفضله. فرصك ان يكون حظك كويس أو وحش هي متساوية");
			
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// here you can add functions
			}
			});
			alertDialog.show();
			
			setContentView(R.layout.activity_exp1);
		}
		if(user.paso == 2) {
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Explanation");
			alertDialog.setMessage("زى ما شرحنا قبل كدة حنطلب منك مقارنة بعض الاختيارات الاستثمارية بعدها أختار القرارالاسثماري ال تظن إنه الأنسبلك وال تفضله هنا حنديلك مبلغ ٥٠ جنيه ولوحالفك حظ سيئ وسحبت كرة حمرا حتخسر مبلغ من ال-٥٠ جنيه دي ولكن لوحالفك حظ كويس وسحبت من الكيس دة كرة خضرا حتكسب مبلغ زيادة عن ال-٥٠ جنيه");
			
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// here you can add functions
			}
			});
			alertDialog.show();
			setContentView(R.layout.activity_exp2);
		}
		user = new InfoUser();
	}
	
	public void continuar(View view) {
		String respuesta = (String) view.getTag();
		Log.v("Respuesta exp 1", respuesta);
		if(user.paso == 1)
			user.resExp1 = respuesta;
		if(user.paso == 2)
			user.resExp2 = respuesta;
		
		// Always return to video.
		Intent intent = new Intent(this, PreguntasDespues.class);
		startActivity(intent);	
	}
}
