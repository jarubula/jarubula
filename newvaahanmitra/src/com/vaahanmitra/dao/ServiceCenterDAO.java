package com.vaahanmitra.dao;

import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarService;
import com.vaahanmitra.model.ServiceEndUser;

public interface ServiceCenterDAO {

	public Set<String> getCarApptId(String email);
	public Set<String> getCarNo(String email);
	public List<ServiceEndUser> getServiceDetails(String query);
	public List<ServiceEndUser> searchCarService(String apptId,String carNo,String email);
	public Set<String> getServiceType(String userId);
	public Set<CarService> getSpareParts(String userId);
	public String insertCarService(List<CarService> carService,String mechanicName,String tax);
	public List<ServiceEndUser> getServiceEndUserById(String apptId);
	public List<BusinessOwnerRegister> getSeviceCenterDetails(String query);
	public List<BusinessOwnerRegister> getServiceCenterByEmail(String email);
	public List<CarService> getCarServiceDetails(String apptId,String billId,String email);
	public List<CarService> getCarServiceDetailsById(String apptId);
	public Set<String> getBikeApptId(String email);
	public Set<String> getBikeNo(String email);
	public List<ServiceEndUser> searchBikeService(String apptId,String bikeNo,String email,int offset,int noOfRecords);
	public Set<String> getBillId(String email);
	public int getNoOfRecords() ;
	public List<ServiceEndUser> getServiceDetailsWithPage(String query);
	public List<ServiceEndUser> searchCarServiceWithPage(String apptId,String carNo,String email,int offset,int noOfRecords);
	
}
