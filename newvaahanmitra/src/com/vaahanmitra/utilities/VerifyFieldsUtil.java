package com.vaahanmitra.utilities;

public class VerifyFieldsUtil {
	
	public String verifyString(String str)
	{
		if(str == null)
		{
			str="NA";
		}
		if(str == "")
		{
			str="NA";
		}
		if(str.equals("ALL"))
		{
			str="NA";
		}
		if(str.equals("Vehicle Type"))
		{
			str="NA";
		}
		if(str.equals("Select City"))
		{
			str="NA";
		}
		if(str.equals("Select State"))
		{
			str="NA";
		}
		if(str.equals("Please wait.."))
		{
			str="NA";
		}
		if(str.equals("-1"))
		{
			str="NA";
		}
		
		return str;
	}
	public String verifyInt(String str)
	{
		if(str == null || str == "")
		{
			str="00";
		}
		return str;
	}

}
