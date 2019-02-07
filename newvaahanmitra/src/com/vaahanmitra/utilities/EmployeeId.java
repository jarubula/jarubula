package com.vaahanmitra.utilities;

import java.util.Calendar;

public class EmployeeId {
	
	public String employeeId(String id){
		String str="VM.";
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String stryear = String.valueOf(year);
		String genId = str+stryear+".EM"+"00"+id;
		return genId;
	}

}
