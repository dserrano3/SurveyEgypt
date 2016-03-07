package com.example.encuesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PreguntasAntes extends Activity {
	private InfoUser user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preguntas_antes);
		
		user = new InfoUser();
		Log.v("sig es: ", String.valueOf(user.sig));
		Log.v("tipo es: ", user.tipoVideo);
		if(user.index == 1) { //originalmente era sig.
			if(user.tipoVideo.equals("H")) {
				text("السؤال رقم واحد: من فضلك تقولينا قد اية انتى متابع الأخبار المتعلقة بالأمراض المعدية المنتشرة في مصر ،ادينا امثلة عن الامراض دى");
			}
			if(user.tipoVideo.equals("F")) {
				text("السؤال رقم واحد : من فضلك تقولنا قد اية انتى متابع الأخبار عن تكاليف العلاج والأدوية في مصر وخاصةً ال لها علاقة بالأمراض المعدية والخطيرة. حدد نطاق معين للأسعار");
			}
			if(user.tipoVideo.equals("C")) {
				text("الأخبار المتعلقة بالحيوانات التي تعيش في القطب الشمالي السؤال رقم واحد : من فضلك تقولنا قد اية انتى متابع اعطنا بعض الأمثال");
			}
		}
		if(user.index == 2) {
			if(user.tipoVideo.equals("H")) {
				text("السؤال رقم إثنان : فكر في الناس ال حواليك والنشاطات اليوميةهل تعتقد أن من السهل أو الممكن أن يصاب حد من الأولاد في علتك زى ابنك بنتك، إبن أختك أو أخوك، بنت أخوك أو أختك ب عدوة الإلتهاب الرئوي");
			}
			if(user.tipoVideo.equals("F")) {
				text("السؤال رقم إثنان : فكر في دخلك الحالي هل تعتقد أن من السهل أو الممكن ليك دفع المبالغ اللازمة لعلاج عدوة الإلتهاب الرئوي لوتعب حد من اولادك او في علتك زى ابنك، ابنتك، إبن أختك أو أختك، إبنة أخيك أو أختك");
			}
			if(user.tipoVideo.equals("C")) {
				text("السؤال رقم إثنان هل تعتقد أنة من السهل أو من الممكن أن الناس في محيطك تعرف معلومات عن الحيوانات في القطب الشمالي");
			}
		}
		if(user.index == 3) {
			if(user.tipoVideo.equals("H")) {
				text("السؤال رقم ثلاثة : كم عدد الأولاد خلال ٥ سنين الماضية في علتك مثل ابنك، بنتك، إبن أختك أو أخوك، بنت أخوك أو أختك ، عانوا من كل أو بعض الاعراض التي طرحناها");
			}
			if(user.tipoVideo.equals("F")) {
				text("السؤال رقم ثلاثة : كم عدد المرات خلال ٥ سنين الماضية ال إضطريت خلالها دفع تكلفة معينة لتأخذ أحد الأولاد في علتك زى ابنك بنتك، إبن أختك أو أخوك، بنت أخوك أو أختك للطبيب أو لشراء الأدوية بعد أن عانى من مرض ما");
			}
			if(user.tipoVideo.equals("C")) {
				text("السؤال رقم ثلاثة   : كم عدد الحيوانات التي تظن أنها معرضة للإنقراض في العالم");
			}
		}
		if(user.index == 4) {
			if(user.tipoVideo.equals("H")) {
				text("السؤال رقم أربعة : من فضلك ان تفكر في خمس حاجات عشان تحمى أطفال في علتك زى ابنك بنتك، إبن أختك أو أخوك، بنت أخوك أو أختك من المخاطر الصحية والأمراض المعدية المحيطة");
			}
			if(user.tipoVideo.equals("F")) {
				text("السؤال رقم أربعة من فضلك فكر في خمسة حاجات ممكن تعملها لتفادى المشاكل المالية التي ممكن أن يكون لها تاثيرعلى علتك");
			}
			if(user.tipoVideo.equals("C")) {
				text("السؤال رقم أربعة أذكر أحد الحيوانات التي تحب وأذكر خمسة صفات لها مفضلة لديك");
			}
		}
		if(user.index == 5) {
			if(user.tipoVideo.equals("H")) {
				text("السؤال رقم خمسة : لوأصابت عدوة إلتهاب الجهاز التنفسي أحد الأولاد في علتك زى ابنك بنتك، إبن أختك أو أخوك، بنت أخوك أو أختك هل تتوقع أن بإمكانك تقديم العناية والرعاية اللازمةفي المنزل . اذكرثلاث ممارسات ممكن أن تقوم بها للعناية بالطفل الذي يعاني من إلتهاب الرئة");
			}
			if(user.tipoVideo.equals("F")) {
				text("السؤال رقم خمسة اذكرثلاث طرق ممكن أن تستخدمها لتوفير الفلوس لعلاج أحد الأولاد في علتك زى ابنك بنتك، إبن أختك أو أخوك، بنت أخوك أو أختك من عدوة إلتهاب الجهاز التنفسي");			
				}
			if(user.tipoVideo.equals("C")) {
				text("السؤال رقم خمسة إصطياد الحيوانات هو هواية لكثير من الأشخاص، هل تعتقد أن فية فوائد لإصطياد الحيوانات. اذكرثلاث أسباب لاختيارك");			
				}
		}
		if(user.index == 6) {
			if(user.tipoVideo.equals("H")) {
				text("من فضلك تقولينا ازاى ممكن يأثر مرض حد من الأولاد في علتك زى ابنك، بنتك، إبن أختك أو أخوك،بنت أخوك أو أختك ، على نشاطاتك اليومية ووقتك . قولى3 طرق");
			}
			if(user.tipoVideo.equals("F")) {
				text(" من فضلك تقولينا ازاى ممكن يأثر مرض حد من الأولاد في علتك زى ابنك، بنتك، إبن أختك أو أخوك بنت أخوك أو أختك ، على الأحوال الاقتصدية للعائلة قولى3طرق");
			}
			if(user.tipoVideo.equals("C")) {
				text("قولى ازاى ممكن يأثر إنقراض بعض الحيوانات في العالم على حياتك هنا في مصر قولى 3 طرق");
			}
		}
	}
	public void text(String t){
		TextView tex=(TextView)findViewById(R.id.textView1); 
		tex.setText(t);
	}
	public void  funcion_continuar(View view) {
		// Borrar estas dos lineas, son solo de debug.
		Intent intent = new Intent(this, Exp7.class); 
		//startActivity(intent);
		//return;
		
		
		if(user.sig == 1 || user.sig == 2)
			 intent = new Intent(this, Exp1.class);
		if(user.sig == 3 || user.sig == 4)
			 intent = new Intent(this, Exp3.class);
		if(user.sig == 5)
			 intent = new Intent(this, MensajeExp5.class);
		if(user.sig == 6)
			 intent = new Intent(this, Exp6.class);
		// If otro vaya a gracias.
		startActivity(intent);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preguntas_antes, menu);
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
}
