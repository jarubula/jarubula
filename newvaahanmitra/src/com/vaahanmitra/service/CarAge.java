package com.vaahanmitra.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CarAge {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public ArrayList getCarAge(String date){
		ArrayList al=new ArrayList();
		int year1=0;
		int year2=0;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String[] s=date.split("-");
		for(int i=0;i<s.length;i++){
			year1=Integer.parseInt(s[0]);
			year2=Integer.parseInt(s[1]);
		}
		year1=year-year1;
		year2=year-year2;
		String sYear=String.valueOf(year1);
		String s1Year=String.valueOf(year2);
		al.add(sYear);
		al.add(s1Year);
	
return al;
	}
	
	public ArrayList getPrice(String price){
		ArrayList al=new ArrayList();
		String price1=null;
		String price2=null;
		
		
		
		String[] s=price.split("-");
		for(int i=0;i<s.length;i++){
			price1=s[0];
			price2=s[1];
		}
	
		al.add(price1);
		al.add(price2);
	
return al;
	}

}
