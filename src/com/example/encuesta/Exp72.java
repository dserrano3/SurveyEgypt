package com.example.encuesta;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Exp72 extends Activity {
	private InfoUser user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exp72);
		
		user = new InfoUser();
		Random rnd = ThreadLocalRandom.current();
		if(user.exp7_2_parte == 0)
			user.exp7_2_parte = rnd.nextInt(2) + 1;
		if(user.exp7_2_parte == 1) {
			TextView t=(TextView)findViewById(R.id.main_text); 
		    t.setText("دلوقتى الكمبيوتر حيختار عشوائياً رقم بين ٠ و- ٣٠ جنيه عشان ندية "+user.third_party+". القيمة" +
		    		" ال حيختارها الكمبوتر حنديها للجمعية وحيخصم من الكمية ال أدينهالك.\n" +
		    		"لو اخترنا اللعبة دى ، حندفع الفلوس حسب القرارات ال أنت اخدتها في المرحلة الأولى أو ال اخترتها عشوائياً بالكمبيوتر"+

		    		 "\n  علشان نقرر إن قرارك ال أخذته في المرحلة الأولى أو قرار الكمبيوتر حيتنفذ حنطلب منك أنك تحدد من ١ إلى ٥ رغبتك بتنفيذ قرارك. ١ يعني أنك مش عايزتنفيذ القراردة أما ٥ فيعني أنك عايزتنفذ قرارك بشدة . هذا الرقم حيتقارن بالرقم الذي اختاره الكمبيوتر عشوائياً من ١ إلى ٥ إيضاً. لو كان الرقم ال أنت حددته أكبر حنطبق قرارك أماإذا كان أصغر فحنطبق قرار الكمبيوتر " +
		    		"في حالة التعادل حنختار عشوائياً  " +
		    		"لو تم إختيار قرارك الذي أخترتة في المرحلة الأولى حندى "+user.third_party+"النسبة ال أنت قررتها حنديلك ما تبقى");
		}
		else if(user.exp7_2_parte == 2){
			TextView t=(TextView)findViewById(R.id.main_text); 
		    t.setText("في المرحلة الأولى أتقسمت مع شريكك مبلغ ٦٠ جنيه و أختارشريكك كمان ازاى يتقسم المبلغ دة معاك ومع المؤسسة " +
		    		". لو تم "+user.third_party+"قرار شريك حتاخد المؤسسة الكمية ال اختارها ليها . والباقي حيتقسم بالتساوي بينك وبين شريكك" +
		    				"أما لوتم إختيار قرارك فحندى "+user.third_party+"الكمية التى أنت حددت والباقي حيتقسم بينك وبين شريكك" +
		    						"\n عشان نحدد إذا قرارك أو قرار الشريك حيتنفذ حنطلب منك أنك تختار من ١ إلى ٥ رغبتك بتنفيذ قرارك" +
		    						"١ يعني أنك مش عايز تنفيذ هذا القرار أما ٥ فيعني أنك عايز تنفيذ قرارك بشدة .  الرقم  دة حيتم مقارنته بالرقم ال اختاره الشريك. لو كان الرقم ال أنت اخترتة أكبر قرارك حيتنفذ أما لو كان الرقم الذي اختاره الشريك أكبرفقرار الشريك هو ال حيتنفذ ");
		}
	}
	
	public void continuar(View view) {
		String respuesta = (String) view.getTag();
		if(user.exp7_2_parte == 1) {
			user.resExp721 = respuesta;
			user.exp7_2_parte ++;
		} else if(user.exp7_2_parte == 2) {
			user.resExp722 = respuesta;
			user.exp7_2_parte --;
		}
		if(!user.entre_72){
			user.entre_72 = true;
			Intent intent = new Intent(this, Exp72.class);
			startActivity(intent);
			return;
		}
		Intent intent = new Intent(this, Exp73.class);
		startActivity(intent);
		
	}
}
