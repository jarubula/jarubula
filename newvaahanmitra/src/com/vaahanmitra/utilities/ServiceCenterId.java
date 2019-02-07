package com.vaahanmitra.utilities;

import java.util.Calendar;

public class ServiceCenterId {

	public String serviceCenterId(String id){

		String str="VM.SC.";
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String stryear = String.valueOf(year);
		String genId = str+stryear+"00"+id;
		return genId;
	}
}
