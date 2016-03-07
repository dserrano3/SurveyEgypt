package com.example.encuesta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import android.os.Environment;
import android.util.Log;


public class Utils {

	public static String tipoVideo(String id){
		return ReadCsvVideo(id);
	}
	
	public static String ReadCsvVideo(String cedula) {
		BufferedReader br;
		File sdcard = Environment.getExternalStorageDirectory();
		// Get the text file
		File file = new File(sdcard, "cedulas.csv");

		try {
			br = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br.readLine()) != null) {
				// manipular texto
				String[] RowData = line.split(",");
				//se encontr� la persona
				if (RowData[0].equals(cedula)) {

					return RowData[1];
				}
			}
		} catch (IOException e) {
			Log.v("error", e.toString());
		}
		return null;

	}
	
	public static void createHeaders(File out) throws IOException{
	    OutputStreamWriter outStreamWriter = null;
	    FileOutputStream outStream = null;  
		try {
				outStream = new FileOutputStream(out, true) ;
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    outStreamWriter = new OutputStreamWriter(outStream); 
		    String line = String.format("ID,VideoType,StartingHour,C1_A,C1_B,C1_C,C2_A,C2_B,C3_A,C3_B,C3_C,ExperimentOrder,E1_A,E1_B,E1_O,E2_A,E2_B,E2_O," +
		    							"E3_1,E3_2,E3_3,E3_4,E3_5,E3_O,E4_1,E4_2,E4_3,E4_4,E4_5,E4_O,E5_1,E5_2," +
		    							"E5_3,Pay5_3,E5_O,E_Experiment6_1,Experiment6_2," +
		    							"Experiment6_3,E6_O,E71_A,E71_B,E72_A,E72_B,ThirdParty,Partner," +
		    							"E73_,E73_B,E73_C,E73_D,E73_E,ExperimentSelectedPayment,FinishingHour,Payment,Gender,Color,Marrital,Order7\n");
		    try {
				outStreamWriter.append(line);
			    outStreamWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static void guardarInfo(String res){

	    File out;
	    OutputStreamWriter outStreamWriter = null;
	    FileOutputStream outStream = null;
	    File sdcard = Environment.getExternalStorageDirectory();
	    out = new File(sdcard, "result.csv");

	    if ( out.exists() == false ){
	        try {
				out.createNewFile();
				createHeaders(out);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    try {
			outStream = new FileOutputStream(out, true) ;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    outStreamWriter = new OutputStreamWriter(outStream, Charset.forName("UTF-8").newEncoder() ); 
	    String line = String.format("%s\n", res);
	    try {
			outStreamWriter.append(line);
		    outStreamWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Lee el valor de otra persona para calcular el 5_2 y 5_3, aleatoriamente.
	public static String ReadCsvValuesOther(int parte) {
		BufferedReader br;
		File sdcard = Environment.getExternalStorageDirectory();
		// Get the text file
		File file = new File(sdcard, "result.csv");
		 if (!file.exists())
			 return "0";

		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			boolean primero = true;
			ArrayList<String[]> al = new ArrayList();
			while ((line = br.readLine()) != null) {
				// Debemmos ignorar la primera linea porque es el header.
				if(primero){
					primero = false;
					continue;
				}
				String[] RowData = line.split(",");
				al.add(RowData);
			}
			if(al.size() == 0)
				return "0";
			Random rnd = ThreadLocalRandom.current();
			// [0, rand.len)
			int pos = rnd.nextInt(al.size());
			if(parte == 2)
				return al.get(pos)[31];
			if(parte == 3)
				return al.get(pos)[32];

			
		} catch (IOException e) {
			Log.v("error", e.toString());
			return "0";
		}
		return null;

	}

}
