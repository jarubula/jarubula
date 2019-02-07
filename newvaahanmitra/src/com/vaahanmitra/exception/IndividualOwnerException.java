package com.vaahanmitra.exception;

public class IndividualOwnerException extends Exception {
	
String message="";
	
	public IndividualOwnerException()
	{
		super();
	}
	
	public IndividualOwnerException(String message)
	{
		this.message=message;
	}
	
	public String toString()
	{
		return "IndividualOwnerException [message "+ this.message;
	}

}
