package com.vaahanmitra.utilities;

import java.util.Calendar;

public class NewVehicleIds {

	public String newCarId(String id){

		String str="VM.NC.";
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String stryear = String.valueOf(year);
		String genId = str+stryear+"00"+id;
		return genId;
	}
	public String newBikeId(String id){

		String str="VM.NB.";
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String stryear = String.valueOf(year);
		String genId = str+stryear+"00"+id;
		return genId;
	}
}
