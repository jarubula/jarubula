package com.vaahanmitra.dao;

import java.util.ArrayList;

import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UserInterestedVehicles;
import com.vaahanmitra.model.UserLogin;

public interface IndividualOwnerRegisterDao {
	
	public String getEmail(String email);
	public boolean individualOwnerActina(IndividualOwnerRegister bo) throws IndividualOwnerException;
	public String addOwner(IndividualOwnerRegister registration, UserLogin login);
	public ArrayList<IndividualOwnerRegister> getOwnerDetails(IndividualOwnerRegister io,int offset,int noOfRecords)throws IndividualOwnerException;
	public ArrayList<IndividualOwnerRegister> getInactiveOwnerDetails(IndividualOwnerRegister io,int offset,int noOfRecords)throws IndividualOwnerException;
	public IndividualOwnerRegister getOwnerDetails(String seqid)throws IndividualOwnerException;
	public int getNoOfRecords() throws IndividualOwnerException;
	public IndividualOwnerRegister getDeatils(String email)throws IndividualOwnerException;
	public String updateProfile(String user_name,IndividualOwnerRegister registration)throws IndividualOwnerException;
	public ArrayList<String> getIndividualOwnerLocations() throws IndividualOwnerException;
	public ArrayList<IndividualOwnerRegister> searchIndividualOwner(IndividualOwnerRegister bo,int offset,int noOfRecords)throws IndividualOwnerException;
	public String updateStatus(String email, String userType)throws IndividualOwnerException;
	public String checkEmailStatus(String email,String carId,String mobileNo,String name);
	public String getEmailStatus(String email,String bikeId,String mobileNo,String name);
	public String checkDEmailStatus(String email, String demail, String carId, String mobileNo, String name);
	public String checkDBEmailStatus(String email, String demail, String bikeId, String mobileNo, String name);
	public ArrayList<IndividualOwnerRegister> getOwnerDetails(IndividualOwnerRegister io, String user_name, int i,
			int maxrowsperpage);
	public ArrayList<String> getIOCities(String email);
	public String setStatus(String emailId, String status, String user_name);
	public String updateProfile(IndividualOwnerRegister registration);
	
	public String addIndividualOwnerFromSearch(IndividualOwnerRegister registration);
	public boolean sendMailToDealers(String checkedVehicles, IndividualOwnerRegister iowner);
	public boolean insertUserInterestedVehicles(UserInterestedVehicles uv);
}
