package com.vaahanmitra.utilities;

import java.util.Calendar;

public class ServiceAppointmentId {
	
	public String genAppointmentId(String id){
		String str="VM";
		String str1="BA";
		String id1=id;
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int date=now.get(Calendar.DATE);
		String stryear=String.valueOf(year);
		String strdate=String.valueOf(date);
		
		String genId=str+stryear+str1+strdate+"00"+id1;
		
		return genId;
	}
	
	public String getCarBillId(String id){
		
		String str="VM";
		String str1="CRB";
		String id1=id;
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String stryear=String.valueOf(year);
		String syear=stryear.substring(2);
		String genId=str+syear+str1+"0"+id1;
		
		return genId;
		
	}

}
