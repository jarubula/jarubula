package com.vaahanmitra.utilities;

import java.util.Calendar;

public class DriverId {

	public String driverId(String id){
		
		String str="VM.D.";
		String id1=id;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String stryear=String.valueOf(year);
		String genId=str+stryear+"00"+id;
		
		return genId;
	}
	
	public String driverEndUserId(String id){
		
		String id1=id;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String stryear=String.valueOf(year);
		
		String genId="VM"+stryear+"DBA"+"00"+id;
		
		return genId;
		
	}
	
	public String driverTripId(String id){
		
		String id1=id;
		Calendar now = Calendar.getInstance();
		int mnth = now.get(Calendar.MONTH);
		mnth+=mnth+1;
		int year = now.get(Calendar.YEAR);
		String stryear=String.valueOf(year);
		String subyear = stryear.substring(Math.max(stryear.length() - 2, 0));
		
		String genId="VM"+mnth+subyear+"TR"+"00"+id;
		
		return genId;
	}
	
public String driverBillId(String id){
		
		String id1=id;
		Calendar now = Calendar.getInstance();
		int mnth = now.get(Calendar.MONTH);
		mnth+=mnth+1;
		int year = now.get(Calendar.YEAR);
		String stryear=String.valueOf(year);
		String subyear = stryear.substring(Math.max(stryear.length() - 2, 0));
		
		String genId="VM"+mnth+subyear+"DRB"+"00"+id;
		
		return genId;
	}
	
}
