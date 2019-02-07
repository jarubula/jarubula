package com.vaahanmitra.exception;

public class BusinessOwnerException extends Exception {
	
String message="";
	
	public BusinessOwnerException()
	{
		super();
	}
	
	public BusinessOwnerException(String message)
	{
		this.message=message;
	}
	
	public String toString()
	{
		return "BusinessOwnerException [message "+ this.message;
	}

}
