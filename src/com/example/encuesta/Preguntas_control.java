package com.example.encuesta;

import java.io.BufferedReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;


public class Preguntas_control extends Activity {
	InfoUser user;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preguntas_control);
		user = new InfoUser();
		siguiente(null);
		View b = findViewById(R.id.button2);
		b.setVisibility(View.GONE);
		b = findViewById(R.id.button3);
		b.setVisibility(View.GONE);
		b = findViewById(R.id.button4);
		b.setVisibility(View.GONE);
	}
	public void siguiente (View view){
		 ImageView myImage= (ImageView) findViewById(R.id.imagenControl); 
		 if (user.parte_control == 1) {
				TextView t = (TextView)findViewById(R.id.texto1); 
				t.setText("المحاور: شكراً على اجوبتك ، ودلوقتى حنأخد راحة من الأسئلة. المقابلة دى تحتوى على جزئين في الجزء الأول سألنا عن عائلتك واحوالك الشخصية و المعيشية وفى الجزء التانى حنعرض عليك فيديو ، وبعدها نأخذ رايك في بعض المقاطع ، وفى الجزء دة ممكن تكسب فلوس بعد ما تعدى لعب معينة . الهدف من اللعبة دى هو فهم أزاى الأشخاص بياخدوا قرارات إقتصادية معينة في مواجهة موقف مشابة في الحياة اليومية. الفلوس ال حتحصل عليها من اللعبة دى مش رسوم لمشاركتك في المقابلة ، كمية الفلوس التي ممكن ان تحصل عليها تعتمد على القرارات ال حتاخدها . ومن المهم أن تعرف أن الأسئلة دى مالهاش إجابة صح أو غلط وعشان كدة لازم قرارك يعكس الإجابة ال تناسبك. سنقوم بسبع العاب مختلفة. وفى كل لعبة ممكن تكسب فلوس. في نهاية اللعبة حنختار عشوائيا واحد من هذه اللعب وندفعلك الكمية المناسبة بناء على إجابتك في اللعبة دى.");
				user.parte_control++;
		 }
		 else if (user.parte_control==2){
			TextView t = (TextView)findViewById(R.id.texto1); 
			t.setText("الأسئلة ستكون على الشكل التالي: مثلا سنطلب منك أن تقارن بين عدة أختيارات إستثمارية وبعدها تختار الإجابة التي تعتبرها مناسبة لك .وذى ما في الحياة ممكن للإستثمار أنة ينجح او يفشل و في حالة الفشل حتاخد فلوس اقل وفى النجاح حتاخد فلوس اكتر . عشان نحدد نجاح أو فشل الإستثمار حتسحب كرة من الكيس دة، لوكانت الكرة خضرا حنقول أن الأستثمار نجح اما لو كانت الكرة حمرا حنقول أنة فشل ، مع العلم ان نسبة نجاح أو فشل الإستثمار متساوية وكل كيس فية خمسة كرات حمرا وخمسة خضرا.");
			 myImage.setImageResource(R.drawable.pregunta_control2);
			 myImage.getLayoutParams().height = 400;
			 myImage.getLayoutParams().width = 400;
			 TextView v = (TextView)findViewById(R.id.texto2); 
			 v.setText("الخيار الأول يسمح لك الحصول على قيمة ثابتة دائماً أما في خيار إثنان إلى ستة فممكن أن تكسب مال أكثر بحال حالفك الحظ وسحبت من هذا الكيس كرة خضراء ولكن إذا سحبت كرة حمراء فيكون حالفك حظ سيئ وتكسب مال أقل");
			 user.parte_control++;
		}
		else if (user.parte_control==3){
			TextView t = (TextView)findViewById(R.id.texto1); 
			t.setText("مثلاً الأختيار الأول حتاخد 18 جنية لوسحبت كرة حمرا أو خضرا .اما اختيار من 2-6 حتاخد فلوس أقل إذا كانت الكرة حمرا . في الاختيار التانى حتاخد 14 جنية للكرة الحمرا اما لوكنت محظوظ وسحبت كرة خضرا حتاخد 26 جنية");
			myImage.setImageResource(R.drawable.pregunta_control2);
			 myImage.getLayoutParams().height = 400;
			 myImage.getLayoutParams().width = 400;
			/*RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(20, 20);
			myImage.setLayoutParams(params);*/
			
			 TextView v = (TextView)findViewById(R.id.texto2); 
			 
			 v.setText(" ");
			 user.parte_control++;
		}
		else if (user.parte_control==4){
			View b = findViewById(R.id.button2);
			b.setVisibility(View.VISIBLE);
			b = findViewById(R.id.button3);
			b.setVisibility(View.VISIBLE);
			b = findViewById(R.id.button4);
			b.setVisibility(View.VISIBLE);
			b = findViewById(R.id.button1);
			b.setVisibility(View.GONE);
			
			TextView t = (TextView)findViewById(R.id.texto1); 
			t.setText(". لو اخترت الأختيار الجاى دة قد اية من الفلوس حتكسب لوسحبت كرة خضرا من الكيس ؟"); 
			myImage.setImageResource(R.drawable.pregunta_control3);
			 myImage.getLayoutParams().height = 400;
			 myImage.getLayoutParams().width = 400;
			user.parte_control++;
		}
		else if (user.parte_control==5){
			Log.v("valor exp1 es: ", (String) view.getTag());
			user.control_balls_1 =  (String) view.getTag();
			TextView t = (TextView)findViewById(R.id.texto1); 
			t.setText(". لو اخترت الأختيار الجاى دة قد اية من الفلوس حتكسب لوسحبت كرة الحمرا من الكيس ؟");
			user.parte_control++;
			
		}else if(user.parte_control==6) {
			user.control_balls_2 =  (String) view.getTag();
			View b = findViewById(R.id.button2);
			b.setVisibility(View.GONE);
			b = findViewById(R.id.button3);
			b.setVisibility(View.GONE);
			b = findViewById(R.id.button4);
			b.setVisibility(View.GONE);
			b = findViewById(R.id.button1);
			b.setVisibility(View.VISIBLE);
			myImage.setImageResource(R.drawable.pregunta_control3);
			 myImage.getLayoutParams().height = 200;
			 myImage.getLayoutParams().width = 200;
			setContentView(R.layout.activity_preguntas_control2);
			user.parte_control++;
		}else if(user.parte_control==7){
			user.parte_control++;
			Intent intent = new Intent(this, Preguntas_control2.class);
			startActivity(intent);
		}
		else if(user.parte_control==8){
			TextView t = (TextView)findViewById(R.id.texto1); 
			t.setText("الجزء الثانى : ليك10محاولات ترمى الكرة داخل السلة ولكن دلوقتى حتتنافس مع شخص آخر حنختارة عشوائياً الشخص دة ممكن يكون لعب او بيلعب نفس اللعبة دى دلوقتى ولو سجلت نقط اكثر من الشخص دة حتاخد 15 جنية لكل محاولة ناجحة ،ولو ماسجلتش نقط اكثرمش حتاخد حاجة لن نخبرك عن الرابح إلا في النهاية وبحال تم إختيار العبة دي لي على اساسها حندفعلك");
			user.parte_control++;
		}else if(user.parte_control==9){
			user.parte_control++;
			Intent intent = new Intent(this, Preguntas_control2.class);
			startActivity(intent);
			
		}else if(user.parte_control==10){ 
			TextView t = (TextView)findViewById(R.id.texto1); 
			t.setText("وأخيراً سنقدم لك بعض الصور التي ينقص منها جزء معين عليك إختيار الشكل المناسب لتكملة الصورة مثلاً :");
			user.parte_control++;
		}else if(user.parte_control==11){
			Intent intent = new Intent(this, Preguntas_control3.class);
			startActivity(intent);
		}
	}
	
	public void calcular(View view) {
		user.control_1 = (String) view.getTag(); 
		// Debe ir a la siguiente pantalla.
		setContentView(R.layout.activity_preguntas_control);
		View b = findViewById(R.id.button2);
		b.setVisibility(View.GONE);
		b = findViewById(R.id.button3);
		b.setVisibility(View.GONE);
		b = findViewById(R.id.button4);
		b.setVisibility(View.GONE);
		TextView t = (TextView)findViewById(R.id.texto1); 
		t.setText("وفى اللعبة دى حنطلب منك رمى كرة داخل سلةحنحطها على بعد 3 أمتار . ليك 10 محاولات ولكل محاولة ناجحة حتاخد مبلغ معين .المحاولة تعتبر ناجحة لو دخلت الكرة فى السلة واستقرت فيها حنسجل عدد المحاولات الناجحة وحتعمل اللعبة دى 3 مرات الفرق الوحيد فيما بينها هو كمية الفلوس ال حتاخدها في كل محاولة ناجحة . مثلا الجزء الأول : ليك 10 محاولات لرمى الكرة داخل السلة لكل محاولة ناجحة ،حتاخد 5 جنية");
	}
	
	
}