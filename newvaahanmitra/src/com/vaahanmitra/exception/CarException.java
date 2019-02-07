package com.vaahanmitra.exception;

public class CarException extends Exception {
	
String message="";
	
	public CarException()
	{
		super();
	}
	
	public CarException(String message)
	{
		this.message=message;
	}
	
	public String toString()
	{
		return "Car Exception [message "+ this.message+"]";
	}

}
