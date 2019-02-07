package com.vaahanmitra.dao;

import java.util.ArrayList;
import java.util.Set;

import com.vaahanmitra.model.ServiceType;

public interface ServiceTypeDao {
	public ArrayList<ServiceType> viewAllServices(int offset,int noOfRecords,String user_name);
	public int getNoOfRecords();
	public String addServicetype(ServiceType serviceType, String emailId);
	public Set<ServiceType> getServiceId(String email);
	public String verifyServiceId(String serviceId, String emailId,String vehicleType);
	public ArrayList<ServiceType> getServices(String email, String serviceId);
}
