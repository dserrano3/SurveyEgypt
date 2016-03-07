package com.example.encuesta;

import java.util.Arrays;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import android.util.Log;

public class InfoUser {
	public static String id;
	public static String tipoVideo, genero;
	public static int paso, sig; // En que paso de experimento voy.
	public static int[] rand; // Orden en el que hara los experimentos.
	public static int numExperimentos = 6; // Para cambiar facilmente si cambian los experimentos.
	public static String resExp1, resExp2, resExp3, resExp4, resExp51, resExp52, resExp53, formaExp5;
	public static String resExp61, resExp62, resExp63, pago;
	public static String third_party, partner, resExp711, resExp712, resExp721, resExp722;
	public static int exp7_parte, exp7_1_parte, exp7_2_parte; 
	public static String ownEndowment, jointEndowment, againstComputer, againstYour, trustParty; // Respuesta experimento 7 parte 3. 
	public static boolean entre_71, entre_72; // Es para saber si es la primera o segunda vez de 71
	public static int  exp5parte, exp6parte;
	public static int index, selected;
	public static String fecha1, color, marrital;
	
	// Estas son las variables para las preguntas de control.
	public static int parte_control;
	public static String control_1, control_balls_1, control_balls_2;
	public static String control_2A;
	public static String control_2B;
	public static String control_3A; 
	public static String control_3B; 
	public static String control_3C; 
	public static int control3_parte, control2_parte;
	
	
	public void start(String id_){
		Log.v("InfoUser", "Funcion start");
		id = id_;
		color = "";
		sig = 0;
		rand = new int[numExperimentos];
		fecha1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		for(int i =0; i < numExperimentos; i++)rand[i] = i+1;
		shuffleArray(rand);
		control_1="red";
		control_2A="3";
		control_2B="88888888";
		control_3A="1111111";
		control_3B="2222222";
		control_3C="44444444";
		index = 0;
		paso = rand[index]; 
		resExp1 = "11|17";
		resExp2 = "-17|17";
		resExp3 = "BBBBB";
		resExp4 = "ABBBB";
		resExp51 = "0";
		resExp52 = "0";
		resExp53 = "0";
		exp5parte = 1; // Deben quedar igual las partes.
		formaExp5 = "B";
		exp6parte = 1;
		resExp61 = "3";
		resExp62 = "1";
		resExp63 = "5";
		selected = 0;
		tipoVideo = "";
		pago = "";
		exp7_parte = 0;
		exp7_1_parte = 0;
		exp7_2_parte = 0;
		entre_71 = false;
		entre_72 = false;
		// Preguntas control.
		parte_control = 1;
		control3_parte = 1;
		control2_parte = 1;
		
		
	}
	
	public String writeRes() {
		String fecha2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String orden = "";
		String res3Comas = "", res4Comas = "";
		for(int i = 0; i< rand.length; ++i)
			orden += rand[i];
		for(int i = 0; i < resExp3.length(); i++)
			res3Comas += (resExp3.charAt(i) + ",");
		for(int i = 0; i < resExp4.length(); i++)
			res4Comas += (resExp4.charAt(i) + ",");
		String res = id + ",";
		// Se va a poner el orden en la variable E1_, E2_, etc.
		res += tipoVideo + ",";
		res += fecha1 + ",";
		res += control_balls_1 + ",";
		res += control_balls_2 + ",";
		res+= control_1+",";
		res+=control_2A+",";
		res+=control_2B+",";
		res+=control_3A+",";
		res+=control_3B+",";
		res+=control_3C+",";
		res += orden + ",";
		// Tenemos dos lineas del exp 1 y 2 para que quede separado.
		res += resExp1.split("\\|")[0] + ",";
		res += resExp1.split("\\|")[1] + ",";
		res += (orden.indexOf("1") + 1) + ",";
		res += resExp2.split("\\|")[0] + ",";
		res += resExp2.split("\\|")[1] + ",";
		res += (orden.indexOf("2") + 1) + ",";
		res += res3Comas;
		res += (orden.indexOf("3") + 1) + ",";
		res += res4Comas;
		res += (orden.indexOf("4") + 1)+ ",";
		res += resExp51 + ",";
		res += resExp52 + ",";
		res += resExp53 + ",";
		res += formaExp5 + ",";
		res += (orden.indexOf("5") + 1) + ",";
		res += resExp61 + ",";
		res += resExp62 + ",";
		res += resExp63 + ",";
		res += (orden.indexOf("6") + 1) + ",";
		res += resExp711 + ",";
		res += resExp712 + ",";
		res += resExp721 + ",";
		res += resExp722 + ",";
		res += third_party + ",";
		res += partner + ",";
		res += ownEndowment + ",";
		res += jointEndowment + ",";
		res += againstComputer + ",";
		res += againstYour + ",";
		res += trustParty + ",";
		res += selected + ",";
		res += fecha2 + ",";
		res += pago + ",";
		res += genero + ",";
		res += color + ",";
		res += marrital;
		res += (exp7_1_parte == 1 ? "12|" : "21|");
		res += (exp7_2_parte == 1 ? "12" : "21");
		return res;
	}
	
	public int sigPantalla() {
		// si acabe vaya a gracias.
		paso = rand[index];
		return rand[index++];
	}

	//Shuffle the array, only used internally.
	private void shuffleArray(int[] ar) {
	  // If running on Java 6 or older, use `new Random()` on RHS here
	  Random rnd = ThreadLocalRandom.current();
	  for (int i = ar.length - 1; i > 0; i--)
	  {
		  int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	}
}