package com.vaahanmitra.dao;

import java.io.InputStream;
import java.util.ArrayList;

import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.UserLogin;

public interface BusinessOwnerRegisterDao {
	
	public String addBusinessOwner(BusinessOwnerRegister bregistration, UserLogin login)throws BusinessOwnerException;
	public String getBusinessEmail(String email)throws BusinessOwnerException;
	public boolean businessOwnerActina(BusinessOwnerRegister bregistration)throws BusinessOwnerException;
	public BusinessOwnerRegister getAddressDetails(String emailId)throws BusinessOwnerException;
	public ArrayList<BusinessOwnerRegister> getInactiveOwnerDetails(BusinessOwnerRegister bregistration,int limit,int offset)throws BusinessOwnerException;
	public int getNoOfRecords() throws BusinessOwnerException;
	public ArrayList<BusinessOwnerRegister> getOwnerDetails(BusinessOwnerRegister bo,int offset,int noOfRecords)throws BusinessOwnerException;
	public ArrayList<String> getBusinessOwnerLocations(String usertype)throws BusinessOwnerException;
	public ArrayList<String> getBusinessOwnerBusinessNames(String bcity,String usertype)throws BusinessOwnerException;
	public ArrayList<BusinessOwnerRegister> searchBusinessOwner(BusinessOwnerRegister bo,int offset,int noOfRecords)throws BusinessOwnerException;
	public BusinessOwnerRegister getDetails(String email) throws BusinessOwnerException;
	public String updateProfile(BusinessOwnerRegister bregistration, String user_name);
	public String updateProfile(String user_name, BusinessOwnerRegister registration, InputStream is);
	public String updateProfile(BusinessOwnerRegister registration, InputStream is);
	public String getUserType(String user_name);
	public BusinessOwnerRegister getBODetails(String boid);
	public String updateStatus(String email, String userType);
	public ArrayList<BusinessOwnerRegister> getAdSearchOwnerDetails(BusinessOwnerRegister bo,int offset,int noOfRecords)throws BusinessOwnerException;
	public ArrayList<BusinessOwnerRegister> getOwnerDetails(BusinessOwnerRegister bo, String user_name, int i,
			int maxrowsperpage);
	public String setStatus(String emailId, String status, String user_name);
	public String searchAuthentication(String email,String v_typr);
	public ArrayList<BusinessOwnerRegister> getCity();
	public ArrayList<BusinessOwnerRegister> getDealers(String brand, String city,String v_type);
	public ArrayList<BusinessOwnerRegister> getSparepartsDealers(String brand,String city,String v_type);
	public  ArrayList<BusinessOwnerRegister> getServiceCenterDealers(String brand, String city, String v_type);
	public  ArrayList<String> getOnRoadPriceofCar(String car_id, String dealer_id);

	
}